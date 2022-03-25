package ac.kr.kw.judge.problemcatalog.service;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemChanged;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemCreated;
import ac.kr.kw.judge.problemcatalog.domain.event.ProblemOpenTimeChanged;
import ac.kr.kw.judge.problemcatalog.repository.ProblemRepository;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProblemChangeServiceImpl implements ProblemChangeService {
    private final ProblemRepository problemRepository;

    @Override
    public void createProblem(ProblemCreated problemCreated) {
        Problem problem = new Problem(problemCreated.getId(),
                problemCreated.getName(),
                problemCreated.getDescription(),
                problemCreated.getInputDescription(),
                problemCreated.getOutputDescription(),
                problemCreated.getScore(),
                problemCreated.getAuthor());
        problemRepository.save(problem);
    }

    @Override
    public void changeProblemInfo(ProblemChanged problemChanged) {
        Problem problem = findProblem(problemChanged.getId());
        problem.changeInfo(problemChanged.getName(),
                problemChanged.getDescription(),
                problemChanged.getInputDescription(),
                problemChanged.getOutputDescription(),
                problemChanged.getScore());
        problemRepository.save(problem);
    }

    @Override
    public void assignOpenTimeOn(ProblemOpenTimeChanged problemOpenTimeChanged) {
        problemRepository.findProblemsByIdIn(problemOpenTimeChanged.getIds())
                .stream().forEach(problem -> problem.openToPublicOn(problemOpenTimeChanged.getOpenTime()));
    }

    private Problem findProblem(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 id의 문제가 존재하지 않습니다.");
                });
    }
}
