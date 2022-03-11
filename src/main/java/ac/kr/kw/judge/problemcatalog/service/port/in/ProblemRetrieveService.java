package ac.kr.kw.judge.problemcatalog.service.port.in;

import ac.kr.kw.judge.problemcatalog.dto.out.ProblemDto;

import java.util.List;

public interface ProblemRetrieveService {
    ProblemDto findProblemDetail(Long problemId);

    List<ProblemDto> findProblemContainingIds(List<Long> problemIds);
}
