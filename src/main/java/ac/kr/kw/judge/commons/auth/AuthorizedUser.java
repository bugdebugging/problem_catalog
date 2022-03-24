package ac.kr.kw.judge.commons.auth;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorizedUser {
}