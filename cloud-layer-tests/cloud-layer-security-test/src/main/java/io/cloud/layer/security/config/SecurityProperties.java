package io.cloud.layer.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author RippleChan
 * @date 2019-03-01 02:29
 */
@ConfigurationProperties(prefix = "spring.security", ignoreUnknownFields = true, ignoreInvalidFields = true)
public class SecurityProperties {

    /**
     * API或Web
     */
    private String authType;

}
