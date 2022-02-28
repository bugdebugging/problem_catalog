package ac.kr.kw.judge.problemcatalog.service;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;
import ac.kr.kw.judge.problemcatalog.repository.ProblemRepository;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemChangeServiceImpl implements ProblemChangeService {
    private final ProblemRepository problemRepository;

    @Override
    public void changeProblemInfo(ProblemChanged problemChanged) {
        Problem problem = new Problem(problemChanged.getId()
                , problemChanged.getName()
                , problemChanged.getDescription()
                , problemChanged.getInputDescription()
                , problemChanged.getOutputDescription()
                , problemChanged.getScore());
        problemRepository.save(problem);
    }
}
