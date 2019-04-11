package io.cloud.layer.hbase.impl.tags;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 基于注解创建Hbase表
 * @author RippleChan
 * @date 2019-04-11 00:58
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Table {

    /**
     * 表名，如果为空则会跳过
     * @return
     */
    String tableName() default "";

    /**
     * 列族：请至少指定一个列族
     * @return
     */
    String families() default "";

    /**
     * 自动创建表：是否自动创建表？项目启动过程中，会自动尝试创建表。新建线程，如果创建失败，并不影响项目启动
     * @return
     */
    boolean auto() default true;

}
