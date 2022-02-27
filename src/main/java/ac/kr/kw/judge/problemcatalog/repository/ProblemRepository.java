package ac.kr.kw.judge.problemcatalog.repository;

import ac.kr.kw.judge.problemcatalog.domain.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProblemRepository extends MongoRepository<Problem,Long> {
}
