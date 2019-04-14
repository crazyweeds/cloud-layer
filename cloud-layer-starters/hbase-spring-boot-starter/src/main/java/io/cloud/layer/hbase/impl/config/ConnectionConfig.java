package io.cloud.layer.hbase.impl.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties({HbaseProperties.class})
@Slf4j
@AutoConfigureOrder(1)
public class ConnectionConfig {

    @Autowired
    private HbaseProperties.FileConfig fileConfig;

    @Autowired
    private HbaseProperties.PropertiesConfig propertiesConfig;

    /**
     * 直接将Connection注入到IOC容器，而非Configuration，因为直接使用Configuration，可能会导致性能问题
     *
     * @return
     */
    @Bean
    public Connection connection() {
        Configuration configuration = HBaseConfiguration.create();
        this.config(configuration);
        try {
            log.info("准备获取hbase连接...");
            Connection connection = ConnectionFactory.createConnection(configuration);
            log.info("成功获取hbase连接...");
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.error("获取Hbase连接失败..。");
        return null;
    }

    /**
     * 通过file和properties的形式载入配置
     *
     * @param configuration
     */
    private void config(Configuration configuration) {
        this.loadFileConfig(configuration);
        this.loadPropertiesConfig(configuration);
    }

    /**
     * 载入property配置
     */
    private void loadPropertiesConfig(Configuration configuration) {
        Map<String, String> properties = propertiesConfig.getConfiguration();
        properties.forEach((key, value) -> {
            if (!StringUtils.isBlank(key) && !StringUtils.isBlank(value)) {
                configuration.set(key, value);
            }
        });
    }

    /**
     * 载入文件配置
     */
    private void loadFileConfig(Configuration configuration) {
        List<URL> filePaths = fileConfig.getFilePaths();
        filePaths.forEach(configuration::addResource);
    }

}
