package io.cloud.layer.swagger;

import io.cloud.layer.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RippleChan
 * @date 2019-02-27 00:34
 */
@SpringBootApplication
@EnableSwagger
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

}
