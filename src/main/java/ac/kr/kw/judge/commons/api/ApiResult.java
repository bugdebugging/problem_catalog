package ac.kr.kw.judge.commons.api;

public class ApiResult<T> {
    private T data;
    private ApiError error;

    public ApiResult(T data, ApiError error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public ApiError getError() {
        return error;
    }

    public static class ApiError {
        private int status;
        private String message;

        public ApiError(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }
    }
}
