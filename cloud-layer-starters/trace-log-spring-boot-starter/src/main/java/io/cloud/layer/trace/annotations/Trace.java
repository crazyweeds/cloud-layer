package io.cloud.layer.trace.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author RippleChan
 * @date 2019-05-26 11:08
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Trace {


    String value() default "";

    /**
     * 链路追踪的链路ID，支持SpEL表达式
     * @return
     */
    @AliasFor
    String traceId() default "";

    /**
     * 必要的描述信息，可忽略
     * @return
     */
    String description() default "";

}
