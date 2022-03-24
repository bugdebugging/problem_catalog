package ac.kr.kw.judge.problemcatalog.service;

import ac.kr.kw.judge.commons.exception.UnAuthorizedException;
import ac.kr.kw.judge.problemcatalog.domain.Problem;
import ac.kr.kw.judge.problemcatalog.domain.ProblemStatus;
import ac.kr.kw.judge.problemcatalog.dto.out.ProblemDto;
import ac.kr.kw.judge.problemcatalog.dto.out.ProblemSummaryItem;
import ac.kr.kw.judge.problemcatalog.repository.ProblemRepository;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemRetrieveServiceImpl implements ProblemRetrieveService {
    private final ProblemRepository problemRepository;

    @Override
    public ProblemDto findProblemDetail(Long problemId, String username) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 id의 문제가 존재하지 않습니다.");
                });
        if (!problem.getAuthor().equals(username) && !problem.canSearchDetailToAnonymous(LocalDateTime.now())) {
            throw new UnAuthorizedException("해당 문제가 공개되어 있지 않습니다.");
        }
        return ProblemDto.fromEntity(problem);
    }

    @Override
    public List<ProblemDto> findProblemContainingIds(List<Long> problemIds) {
        return problemRepository.findProblemsByIdIn(problemIds)
                .stream().map(problem -> ProblemDto.fromEntity(problem))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProblemSummaryItem> findProblems(int page, int size) {
        return problemRepository.findAll(PageRequest.of(page, size))
                .stream().map(problem -> ProblemSummaryItem.of(problem.getId(), problem.getName(), problem.getScore()))
                .collect(Collectors.toList());
    }
}
