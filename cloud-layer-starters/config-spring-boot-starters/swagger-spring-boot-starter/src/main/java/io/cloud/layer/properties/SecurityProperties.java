package io.cloud.layer.properties;

import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 安全相关的配置
 */
@Data
@ConfigurationProperties("swagger.config.security")
public class SecurityProperties {

    /**
     * 是否开启 token 验证, 默认开启。
     */
    private boolean enableTokenAuth = true;

    /**
     * 在web上面显示的名称
     */
    private String name = "token";

    /**
     * key名称,默认：Authorization。
     */
    private String keyName = "Authorization";

    /**
     * 放在什么地方呢？默认放在 header 上面
     */
    private In in = In.HEADER;


}
