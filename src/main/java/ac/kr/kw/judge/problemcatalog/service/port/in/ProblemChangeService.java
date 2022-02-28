package ac.kr.kw.judge.problemcatalog.service.port.in;

import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;

public interface ProblemChangeService {
    void changeProblemInfo(ProblemChanged problemChanged);
}
