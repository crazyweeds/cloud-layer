package io.cloud.layer.security.handle;

import io.cloud.layer.security.core.AuthenticateErrorResponce;
import io.cloud.layer.security.properties.SpringSecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 用于区分 REST 接口和传统 Web 项目
 * @author RippleChan
 * @date 2019-02-24 19:03
 */
@Slf4j
@RestController
public class RedirectSecurityRequestController {

    {
        log.info("初始化 Spring Security 重定向");
    }

    @Autowired
    private ApplicationContext applicationContext;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private SpringSecurityProperties securityProperties;

    /**
     * 需要授权的时候，如果是 Web 开发，则跳转到用户自定义的登录页面
     * 如果是 REST 接口开发，则返回一个 {@link AuthenticateErrorResponce} 类型的 JSON 字符串，如果用户未自定义 {@link AuthenticateErrorResponce} ，则返回 {@link HttpStatus#UNAUTHORIZED}
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "${spring.security.loginPath}")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (!Objects.isNull(savedRequest)) {
            String redirectUrl = savedRequest.getRedirectUrl();
            String contentType = request.getContentType();
            if (StringUtils.endsWithIgnoreCase(redirectUrl, ".html")) {
                redirectStrategy.sendRedirect(request,response,securityProperties.getLoginPage());
            }
        }
        AuthenticateErrorResponce authenticateErrorResponce = applicationContext.getBean(AuthenticateErrorResponce.class);
        /**
         * 如果用户没有实现自定义返回，那么只能返回个默认的了
         */
        if (Objects.isNull(authenticateErrorResponce)) {
            return HttpStatus.UNAUTHORIZED.toString();
        }
        return authenticateErrorResponce;
    }

}
