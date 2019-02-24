package io.cloud.layer.security;

import io.cloud.layer.security.handle.SwitctSecurityRequestController;
import io.cloud.layer.security.properties.EnableSpringSecurityProperties;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({
        EnableSpringSecurityProperties.class,
        SwitctSecurityRequestController.class
})
@EnableWebSecurity
public @interface EnableSecurity {



}
