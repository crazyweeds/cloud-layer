package io.cloud.layer.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author RippleChan
 * @date 2019-03-01 02:23
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 自定义登录页面
         */
        http.formLogin().loginPage("/login.html").permitAll();
        http.formLogin().loginProcessingUrl("/login/auth");
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }

}
