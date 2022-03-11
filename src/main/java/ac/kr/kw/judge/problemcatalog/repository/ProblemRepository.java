package ac.kr.kw.judge.problemcatalog.repository;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProblemRepository extends MongoRepository<Problem,Long> {
    List<Problem>findProblemsByIdIn(List<Long>problemIds);
}
