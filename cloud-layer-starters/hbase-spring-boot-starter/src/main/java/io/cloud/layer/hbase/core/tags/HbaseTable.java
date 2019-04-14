package io.cloud.layer.hbase.core.tags;

import io.cloud.layer.hbase.core.enums.Strategy;
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
public @interface HbaseTable {

    /**
     * 表名，如果为空则会跳过
     * @return
     */
    String tableName() default "";

    /**
     * 列族，如果有多个，请用逗号隔开
     * @return
     */
    String families() default "default";

    /**
     * 自动创建表：是否自动创建表？项目启动过程中，会自动尝试创建表。新建线程，如果创建失败，并不影响项目启动
     * @return
     */
    boolean auto() default true;

    /**
     * 创建表的模式，全部模式请看：{@link Strategy}
     * @return
     */
    Strategy strategy() default Strategy.SKIP;

}
