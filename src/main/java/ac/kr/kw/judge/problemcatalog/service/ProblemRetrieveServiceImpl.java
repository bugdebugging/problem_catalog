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
    public List<ProblemSummaryItem> findProblemContainingIds(List<Long> problemIds, String username) {
        List<Problem> problems = problemRepository.findProblemsByIdIn(problemIds);
        verifyProblemsCreateBy(problems, username);

        return problems.stream().map(problem -> ProblemSummaryItem.fromEntity(problem))
                .collect(Collectors.toList());
    }

    private void verifyProblemsCreateBy(List<Problem> problems, String aUsername) {
        if (problems.stream().filter(problem -> problem.getAuthor().equals(aUsername))
                .collect(Collectors.toList()).size() != problems.size()) {
            throw new UnAuthorizedException("본인의 문제만 대회에서 선택할 수 있습니다.");
        }
    }

    @Override
    public List<ProblemSummaryItem> findProblems(int page, int size) {
        return problemRepository.findAll(PageRequest.of(page, size))
                .stream().map(problem -> ProblemSummaryItem.fromEntity(problem))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProblemSummaryItem> findProblemBelongToAuthor(String author) {
        return problemRepository.findProblemsByAuthor(author)
                .stream().map(problem -> ProblemSummaryItem.fromEntity(problem))
                .collect(Collectors.toList());
    }
}
