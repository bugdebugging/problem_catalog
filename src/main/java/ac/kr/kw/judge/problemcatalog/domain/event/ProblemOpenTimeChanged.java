package ac.kr.kw.judge.problemcatalog.domain.event;

import java.time.LocalDateTime;

public class ProblemOpenTimeChanged {
    private Long id;
    private LocalDateTime openTime;

    public ProblemOpenTimeChanged(Long id, LocalDateTime openTime) {
        this.id = id;
        this.openTime = openTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }
}
