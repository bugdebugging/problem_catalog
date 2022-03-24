package ac.kr.kw.judge.problemcatalog.service.port.in;

import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemCreated;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemOpenTimeChanged;

public interface ProblemChangeService {
    void createProblem(ProblemCreated problemCreated);

    void changeProblemInfo(ProblemChanged problemChanged);

    void assignOpenTimeOn(ProblemOpenTimeChanged problemOpenTimeChanged);
}
