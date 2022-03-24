package ac.kr.kw.judge.problemcatalog.adapter.in.event;

import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemCreated;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemOpenTimeChanged;
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

    @KafkaListener(topics = "problem_changed", groupId = "problem-catalog-group")
    public void consumeProblemChangedEvent(String message) {
        try {
            ProblemChanged problemChanged = objectMapper.readValue(message, ProblemChanged.class);
            problemChangeService.changeProblemInfo(problemChanged);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "problem_created", groupId = "problem-catalog-group")
    public void consumeProblemCreatedEvent(String message) {
        try {
            ProblemCreated problemCreated = objectMapper.readValue(message, ProblemCreated.class);
            problemChangeService.createProblem(problemCreated);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "problem_open_time_changed", groupId = "problem-catalog-group")
    public void consumeProblemOpenTimeChangedEvent(String message) {
        try {
            ProblemOpenTimeChanged problemOpenTimeChanged = objectMapper.readValue(message, ProblemOpenTimeChanged.class);
            problemChangeService.assignOpenTimeOn(problemOpenTimeChanged);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
