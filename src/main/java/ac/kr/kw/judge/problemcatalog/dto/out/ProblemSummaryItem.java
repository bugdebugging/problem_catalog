package ac.kr.kw.judge.problemcatalog.dto.out;

import ac.kr.kw.judge.problemcatalog.domain.Problem;

public class ProblemSummaryItem {
    private Long id;
    private String name;
    private int score;

    private ProblemSummaryItem(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public static ProblemSummaryItem fromEntity(Problem problem) {
        return new ProblemSummaryItem(problem.getId(), problem.getName(), problem.getScore());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
