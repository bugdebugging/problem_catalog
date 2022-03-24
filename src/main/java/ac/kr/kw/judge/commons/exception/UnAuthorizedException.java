package ac.kr.kw.judge.commons.exception;

public class UnAuthorizedException extends RuntimeException{
    public UnAuthorizedException() {
    }

    public UnAuthorizedException(String message) {
        super(message);
    }
}
