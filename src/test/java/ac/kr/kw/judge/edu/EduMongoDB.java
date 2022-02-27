package ac.kr.kw.judge.edu;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import ac.kr.kw.judge.problemcatalog.repository.ProblemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EduMongoDB {
    @Autowired
    ProblemRepository problemRepository;

    @Test
    void 저장_및_조회() {
        final Long id = 1L;
        final String name = "paildrom string";
        final String description = "description 1~";
        final String inputDescription = "input description 1~";
        final String outputDescription = "output description 1~";
        final int score = 1800;

        Problem problem = new Problem(id
                , name
                , description
                , inputDescription
                , outputDescription
                , score);
        problemRepository.save(problem);
        Problem savedProblem = problemRepository.findById(1L).get();

        assertEquals(id, savedProblem.getId());
        assertEquals(name, savedProblem.getName());
        assertEquals(description, savedProblem.getDescription());
        assertEquals(inputDescription, savedProblem.getInputDescription());
        assertEquals(outputDescription, savedProblem.getOutputDescription());
        assertEquals(score, savedProblem.getScore());
    }
}
