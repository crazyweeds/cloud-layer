package io.cloud.layer.auth.basic;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author RippleChan
 * @date 2019-03-01 23:04
 */
@ConfigurationProperties(prefix = "basic.auth")
public class AuthProperties {

    /**
     * 无需授权的路径，比如静态资源、用户登录。比如需要对/login路径放行，直接增加/login即可。
     */
    private String[] ignorePath;



}
