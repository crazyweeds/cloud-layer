package io.cloud.layer.hbase.impl;

import io.cloud.layer.hbase.impl.config.HbaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author RippleChan
 * @date 2019-04-11 21:54
 */
@EnableConfigurationProperties(value = {HbaseProperties.class})
public @interface EnableHbase {
}
