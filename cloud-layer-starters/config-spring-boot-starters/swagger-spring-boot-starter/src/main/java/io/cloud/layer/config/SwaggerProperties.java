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

    private String version = "V1.0";
    private String title = "swagger-spring-boot-starter";
    private String description = "Swagger-UI";
    private String termsOfServiceUrl = "http://www.cloud-layer.io";
    private String license = "Apache License";
    private String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
    private String contactName = "RippleChan";


}
