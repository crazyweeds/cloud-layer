package io.cloud.layer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @see springfox.documentation.service.ApiInfo
 * @author RippleChan
 * @date 2019-02-27 01:52
 */
@Data
@ConfigurationProperties("swagger.api.info")
public class SwaggerProperties {

    /**
     * Api接口版本
     */
    private String version = "V1.0";

    /**
     * title名称
     */
    private String title = "swagger-spring-boot-starter";

    /**
     * 描述信息
     */
    private String description = "Swagger-UI";

    /**
     * 团队URL
     */
    private String termsOfServiceUrl = "http://www.cloud-layer.io";

    /**
     * 协议
     */
    private String license = "Apache License";

    /**
     * 协议内容地址
     */
    private String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";

    /**
     * 联系人
     */
    private String contactName = "RippleChan";


}
