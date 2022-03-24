package ac.kr.kw.judge.problemcatalog.domain;

public enum ProblemStatus {
    ENABLE("ENABLE"), DISABLE("DISABLE");
    private String value;

    ProblemStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}