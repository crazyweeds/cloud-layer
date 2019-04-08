package io.cloud.layer.auth.basic.mark;

import java.lang.annotation.*;

/**
 * 对所有人开放，无需认证的，使用该注解直接放行
 * @author RippleChan
 * @date 2019-03-01 22:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Permit {



}
