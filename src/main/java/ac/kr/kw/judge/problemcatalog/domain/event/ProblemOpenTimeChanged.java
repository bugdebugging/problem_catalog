package ac.kr.kw.judge.problemcatalog.domain.event;

import java.time.LocalDateTime;
import java.util.List;

public class ProblemOpenTimeChanged {
    private List<Long> ids;
    private LocalDateTime openTime;

    public ProblemOpenTimeChanged(List<Long> ids, LocalDateTime openTime) {
        this.ids = ids;
        this.openTime = openTime;
    }

    public List<Long> getIds() {
        return ids;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }
}
