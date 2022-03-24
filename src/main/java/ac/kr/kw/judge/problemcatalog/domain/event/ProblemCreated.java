package ac.kr.kw.judge.problemcatalog.domain.event;

public class ProblemCreated {
    private Long id;
    private String name;
    private String description;
    private String inputDescription;
    private String outputDescription;
    private int score;
    private String author;

    public ProblemCreated(Long id, String name, String description, String inputDescription, String outputDescription, int score, String author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inputDescription = inputDescription;
        this.outputDescription = outputDescription;
        this.score = score;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }
}
