package ac.kr.kw.judge.problemcatalog.service.port.in;

import ac.kr.kw.judge.problemcatalog.dto.out.ProblemDto;
import ac.kr.kw.judge.problemcatalog.dto.out.ProblemSummaryItem;

import java.util.List;

public interface ProblemRetrieveService {
    ProblemDto findProblemDetail(Long problemId, String username);

    List<ProblemSummaryItem> findProblemContainingIds(List<Long> problemIds, String username);

    List<ProblemSummaryItem> findProblems(int page, int size);

    List<ProblemSummaryItem> findProblemBelongToAuthor(String author);
}
