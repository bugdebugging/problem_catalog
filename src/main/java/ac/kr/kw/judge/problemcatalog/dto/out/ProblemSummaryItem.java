package ac.kr.kw.judge.problemcatalog.dto.out;

public class ProblemSummaryItem {
    private Long id;
    private String name;
    private int score;

    private ProblemSummaryItem(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public static ProblemSummaryItem of(Long id, String name, int score) {
        return new ProblemSummaryItem(id, name, score);
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
