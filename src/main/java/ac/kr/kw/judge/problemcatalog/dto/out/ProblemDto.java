package ac.kr.kw.judge.problemcatalog.dto.out;

import ac.kr.kw.judge.problemcatalog.domain.Problem;

public class ProblemDto {
    private Long id;
    private String name;
    private String description;
    private String inputDescription;
    private String outputDescription;
    private int score;

    private ProblemDto(Long id, String name, String description, String inputDescription, String outputDescription, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inputDescription = inputDescription;
        this.outputDescription = outputDescription;
        this.score = score;
    }

    public static ProblemDto fromEntity(Problem problem) {
        return new ProblemDto(problem.getId()
                , problem.getName()
                , problem.getDescription()
                , problem.getInputDescription()
                , problem.getOutputDescription()
                , problem.getScore());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public String getOutputDescription() {
        return outputDescription;
    }

    public int getScore() {
        return score;
    }
}
