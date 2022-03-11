package ac.kr.kw.judge.problemcatalog.service;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import ac.kr.kw.judge.problemcatalog.dto.out.ProblemDto;
import ac.kr.kw.judge.problemcatalog.repository.ProblemRepository;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemRetrieveServiceImpl implements ProblemRetrieveService {
    private final ProblemRepository problemRepository;

    @Override
    public ProblemDto findProblemDetail(Long problemId) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 id의 문제가 존재하지 않습니다.");
                });
        return ProblemDto.fromEntity(problem);
    }

    @Override
    public List<ProblemDto> findProblemContainingIds(List<Long> problemIds) {
        return problemRepository.findProblemsByIdIn(problemIds)
                .stream().map(problem -> ProblemDto.fromEntity(problem))
                .collect(Collectors.toList());
    }
}
