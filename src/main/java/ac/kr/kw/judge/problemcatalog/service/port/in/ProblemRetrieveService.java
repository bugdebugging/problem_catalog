package ac.kr.kw.judge.problemcatalog.service.port.in;

import ac.kr.kw.judge.problemcatalog.dto.out.ProblemDto;

public interface ProblemRetrieveService {
    ProblemDto findProblemDetail(Long problemId);
}
