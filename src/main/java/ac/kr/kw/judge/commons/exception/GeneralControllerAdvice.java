package ac.kr.kw.judge.commons.exception;

import ac.kr.kw.judge.commons.api.ApiResult;
import ac.kr.kw.judge.commons.api.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralControllerAdvice {
    @ExceptionHandler({IllegalArgumentException.class,
            IllegalStateException.class})
    public ResponseEntity<ApiResult> handleBusinessException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiUtils.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
