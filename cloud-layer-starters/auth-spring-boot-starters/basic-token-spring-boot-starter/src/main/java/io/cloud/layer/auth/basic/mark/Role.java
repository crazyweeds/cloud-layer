package io.cloud.layer.auth.basic.mark;

import java.lang.annotation.*;

/**
 * 如果该用户需要角色，可以使用该注解标注
 * @author RippleChan
 * @date 2019-03-01 22:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Role {



}
