package io.cloud.layer.uitls.checker;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * String 类型的 not blank 校验
 * @see BeanChecker#notBlaknChecker(java.lang.Object)
 * @author RippleChan
 * @date 2019-03-08 18:35
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {

    String value() default "";

}
