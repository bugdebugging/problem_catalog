package ac.kr.kw.judge.problemcatalog.adapter.in.web;

import ac.kr.kw.judge.commons.api.ApiResult;
import ac.kr.kw.judge.commons.api.ApiUtils;
import ac.kr.kw.judge.problemcatalog.dto.in.ProblemSearchRequest;
import ac.kr.kw.judge.problemcatalog.service.port.in.ProblemRetrieveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProblemRetrieveController {
    private final ProblemRetrieveService problemRetrieveService;

    @GetMapping("/api/problem_catalogs/{problemId}")
    public ApiResult retrieveProblemDetail(@PathVariable("problemId") Long problemId) {
        return ApiUtils.success(problemRetrieveService.findProblemDetail(problemId));
    }

    @GetMapping("/api/problem_catalogs/containing")
    public ApiResult retrieveProblemContainingIds(@RequestBody ProblemSearchRequest problemSearchRequest) {
        return ApiUtils.success(problemRetrieveService.findProblemContainingIds(problemSearchRequest.getProblemIds()));
    }
}
