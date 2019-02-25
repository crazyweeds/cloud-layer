package io.cloud.layer.security.config;

import io.cloud.layer.security.core.LoginTypeEnum;
import io.cloud.layer.security.properties.SpringSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Objects;

/**
 * @author RippleChan
 * @date 2019-02-24 23:56
 */
@EnableConfigurationProperties(SpringSecurityProperties.class)
public class SecurityCoreConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringSecurityProperties securityProperties;

    /**
     * 将 Properties 中的值配置到 Spring Security 中
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 不需要认证的地址
         */
        this.ignorePathConfig(http);
        /**
         * 登录方式,以及登录页面、登录提交地址处理
         */
        this.loginType(http);
        /**
         * CSRF开关
         */
        this.isDisableCsrf(http);
        /**
         * 是否开启登录验证
         */
        this.enableAuthorizeRequests(http);
    }

    private void enableAuthorizeRequests(HttpSecurity http) throws Exception {
        if (securityProperties.isEnableAuthorizeRequests()) {
            http.authorizeRequests().anyRequest().authenticated();
        }
    }

    private void loginType(HttpSecurity http) throws Exception {
        LoginTypeEnum loginType = securityProperties.getLoginType();
        switch (loginType) {
            case FORM:
                http.formLogin().loginPage(securityProperties.getLoginPage()).permitAll();
                http.formLogin().loginProcessingUrl(securityProperties.getLoginProcessingUrl()).permitAll();
                break;
            case OAUTH2:
                http.oauth2Login().loginPage(securityProperties.getLoginPage()).permitAll();
                http.oauth2Login().loginProcessingUrl(securityProperties.getLoginProcessingUrl()).permitAll();
                break;
            case OPENID:
                http.openidLogin().loginPage(securityProperties.getLoginPage()).permitAll();
                http.openidLogin().loginProcessingUrl(securityProperties.getLoginProcessingUrl()).permitAll();
                break;
            default:
                http.formLogin().loginPage(securityProperties.getLoginPage()).permitAll();
                http.formLogin().loginProcessingUrl(securityProperties.getLoginProcessingUrl()).permitAll();
        }
    }


    private void ignorePathConfig(HttpSecurity http) throws Exception {
        if (!Objects.isNull(securityProperties.getIgnorePath()) && securityProperties.getIgnorePath().length != 0) {
            http.authorizeRequests().antMatchers(securityProperties.getIgnorePath()).permitAll();
        }
    }


    private void isDisableCsrf(HttpSecurity http) throws Exception {
        if (securityProperties.getDisableCsrf()) {
            http.csrf().disable();
        }
    }

}
