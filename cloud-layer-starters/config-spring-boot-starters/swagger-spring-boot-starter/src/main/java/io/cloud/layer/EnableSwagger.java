package io.cloud.layer;

import io.cloud.layer.config.SwaggerConfig;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.*;

/**
 * @author RippleChan
 * @date 2019-02-26 23:45
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableSwagger2
@Import({SwaggerConfig.class})
public @interface EnableSwagger {

}


