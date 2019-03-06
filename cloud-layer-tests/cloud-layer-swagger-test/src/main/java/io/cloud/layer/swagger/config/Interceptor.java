package io.cloud.layer.swagger.config;

import io.cloud.layer.uitls.RequestUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RippleChan
 * @date 2019-03-06 23:40
 */
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String body = RequestUtils.getBody((HttpServletRequest) request, false);
        System.out.println(body);
        return true;
    }
}
