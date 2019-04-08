package io.cloud.layer.websocket;

import io.cloud.layer.websocket.config.WebSocketConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({WebSocketConfig.class})
public @interface WebSocketEnabled {



}
