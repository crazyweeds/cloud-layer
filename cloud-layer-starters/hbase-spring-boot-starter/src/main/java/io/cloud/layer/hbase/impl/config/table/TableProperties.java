package io.cloud.layer.hbase.impl.config.table;

import io.cloud.layer.hbase.core.enums.Strategy;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hbase.config.table")
@Data
public class TableProperties {

    /**
     * 创建表的策略，模式列表：{@link Strategy}
     */
    private Strategy strategy = Strategy.SKIP;



}
