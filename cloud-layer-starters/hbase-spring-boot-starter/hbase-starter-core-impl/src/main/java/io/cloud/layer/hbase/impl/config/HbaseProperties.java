package io.cloud.layer.hbase.impl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author RippleChan
 * @date 2019-04-11 21:54
 */
@ConfigurationProperties(prefix = "hbase.zookeeper")
public class HbaseProperties {

    private String quorum;

    private String propertyClientPort;

}
