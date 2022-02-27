package ac.kr.kw.judge.commons.api;

public class ApiUtils {
    public static <T> ApiResult success(T data) {
        return new ApiResult(data, null);
    }

    public static ApiResult fail(int status, String message) {
        return new ApiResult(null, new ApiResult.ApiError(status, message));
    }

    public static ApiResult fail(int status, Throwable throwable) {
        return new ApiResult(null, new ApiResult.ApiError(status, throwable.getMessage()));
    }
}
