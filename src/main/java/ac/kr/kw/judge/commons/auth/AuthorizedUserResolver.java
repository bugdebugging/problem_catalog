package ac.kr.kw.judge.commons.auth;

import ac.kr.kw.judge.commons.exception.UnAuthorizedException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

import static org.apache.logging.log4j.util.Strings.isNotEmpty;

public class AuthorizedUserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(String.class) &&
                parameter.hasParameterAnnotation(AuthorizedUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String username = request.getHeader("X-USERNAME");
        if (!isNotEmpty(username)) {
            throw new UnAuthorizedException("you are forbidden.");
        }
        return username;
    }
}
