package io.cloud.layer.hbase.impl.config.table;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hbase.config.table")
@Data
public class TableProperties {

    /**
     * 创建表的策略，模式列表：{@link Strategy}
     */
    private Strategy strategy = Strategy.SKIP;


    public enum Strategy {

        /**
         * 覆盖模式：如果存在则删除然后重新创建
         */
        OVERRIDE,
        /**
         * 更新模式：如果不存在，则创建，如果存在，则查看属性是否变动，如果变动则更新
         */
        UPDATE,
        /**
         * 忽略模式：如果表存在，直接跳过
         */
        SKIP;

    }

}
