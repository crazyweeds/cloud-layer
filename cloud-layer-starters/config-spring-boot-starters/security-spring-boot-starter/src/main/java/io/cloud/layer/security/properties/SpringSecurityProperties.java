package io.cloud.layer.security.properties;

import io.cloud.layer.security.config.SecurityCoreConfig;
import io.cloud.layer.security.core.LoginTypeEnum;
import io.cloud.layer.security.handle.RedirectSecurityRequestController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author RippleChan
 * @date 2019-02-24 19:01
 */
@Data
@ConfigurationProperties(prefix = "spring.security")
@Slf4j
public class SpringSecurityProperties {

    {
        if (log.isDebugEnabled()) {
            log.debug("准备初始化 Spring Security");
        }
    }


    /**
     * CSRF防护开关，TRUE=关闭Csrf，FALSE=开启 CSRF
     * 默认关闭 CRSF 防护
     */
    private Boolean disableCsrf = Boolean.TRUE;

    /**
     * 不需要授权认证的路径
     */
    private String[] ignorePath = {};

    /**
     * 用于处理登录请求的地址
     */
    private String loginProcessingUrl = "/login";

    /**
     * @see RedirectSecurityRequestController#redirect(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * 登录页面，对于非接口开发的时候，一定需要配置
     */
    private String loginPage = "/login.html";

    /**
     * @see {@link SecurityCoreConfig#enableAuthorizeRequests(org.springframework.security.config.annotation.web.builders.HttpSecurity)}
     * 默认开启
     */
    private boolean enableAuthorizeRequests = true;

    /**
     * 方式
     */
    private LoginTypeEnum loginType = LoginTypeEnum.FORM;


}
