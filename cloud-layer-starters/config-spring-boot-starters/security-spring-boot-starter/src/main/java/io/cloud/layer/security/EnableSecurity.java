package io.cloud.layer.security;

import io.cloud.layer.security.config.SecurityCoreConfig;
import io.cloud.layer.security.handle.RedirectSecurityRequestController;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({
        RedirectSecurityRequestController.class,
        SecurityCoreConfig.class
})
@EnableWebSecurity
public @interface EnableSecurity {



}
