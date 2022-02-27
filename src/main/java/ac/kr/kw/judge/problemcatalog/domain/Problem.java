package ac.kr.kw.judge.problemcatalog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Problem {
    @Id
    private Long id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private String inputDescription;

    @Field
    private String outputDescription;

    @Field
    private int score;

    public Problem(Long id, String name, String description, String inputDescription, String outputDescription, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inputDescription = inputDescription;
        this.outputDescription = outputDescription;
        this.score = score;
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
