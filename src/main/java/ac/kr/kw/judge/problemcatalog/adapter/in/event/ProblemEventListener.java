package ac.kr.kw.judge.problemcatalog.adapter.in.event;

import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemChangeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProblemEventListener {
    private final ObjectMapper objectMapper;
    private final ProblemChangeService problemChangeService;

    @KafkaListener(topics = "problem", groupId = "problem-catalog-group")
    public void consumeProblemEvent(String message) {
        try {
            ProblemChanged problemChanged = objectMapper.readValue(message, ProblemChanged.class);
            problemChangeService.changeProblemInfo(problemChanged);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("ProblemChanged의 형태가 아닙니다:" + e.getMessage());
        }
    }
}
