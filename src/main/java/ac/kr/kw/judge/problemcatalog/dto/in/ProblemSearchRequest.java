package ac.kr.kw.judge.problemcatalog.dto.in;

import java.util.List;

public class ProblemSearchRequest {
    private List<Long>problemIds;

    public ProblemSearchRequest() {
    }

    public List<Long> getProblemIds() {
        return problemIds;
    }
}
