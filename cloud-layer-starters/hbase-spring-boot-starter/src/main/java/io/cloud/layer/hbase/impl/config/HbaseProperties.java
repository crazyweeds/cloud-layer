package io.cloud.layer.hbase.impl.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * https://github.com/apache/hbase/blob/master/hbase-server/src/test/resources/hbase-site.xml
 * http://hadoop.apache.org/docs/r2.7.2/hadoop-project-dist/hadoop-common/core-default.xml
 * /org/apache/hbase/hbase-common/2.0.1/hbase-common-2.0.1.jar!/hbase-default.xml
 * @author RippleChan
 * @date 2019-04-11 21:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
@Configuration
public class HbaseProperties {

    {
        log.info(">>> load hbase config...");
    }

    /**
     * 通过xml的形式配置
     */
    private FileConfig file;

    /**
     * 通过key-value的方式配置
     */
    private PropertiesConfig properties;


    /**
     * 通过文件的形式配置：在属性非常多的情况下，这是一种非常不错的形式，可以保证参数与hbase环境的高度一致，如果出现配置变更，直接替换新文件即可，无需改动代码
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Configuration
    @AutoConfigureOrder(0)
    @ConfigurationProperties(prefix = "hbase.config.file")
    public static class FileConfig {

        /**
         * 通常是 core-site.xml 和 hbase-sime.xml 文件路径,如果文件放在classPath目录下，请以：classpath: 作为起始值
         */
        private Map<String, String> files;

        private final static String CLASS_PATH_RPEFIX = "classpath:";

        public List<URL> getFilePaths() {
            ArrayList<URL> filePaths = new ArrayList<>();
            if (Objects.isNull(files)) {
                return Collections.emptyList();
            }
            files.forEach((key, value) -> {
                if (!StringUtils.isBlank(value)) {
                    if (value.toLowerCase().startsWith(CLASS_PATH_RPEFIX)) {
                        URL systemResource = ClassLoader.getSystemResource(value.split(CLASS_PATH_RPEFIX)[1]);
                        filePaths.add(systemResource);
                    } else {
                        try {
                            filePaths.add(new URL(value));
                        } catch (MalformedURLException e) {
                            log.error("读取文件配置失败");
                            e.printStackTrace();
                        }
                    }
                }
            });
            return filePaths;
        }

    }

    /**
     * 在某些场景下，文件形式的配置方式，可能并非我们想要的，那就可以通过application-*.properties配置文件的key-value形式配置，如果两种方式一起使用，两者的所有配置项将会合并，如果存在同样配置的时候，Properties形式的将会覆盖File类型的配置
     */
    @Slf4j
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Configuration
    @AutoConfigureOrder
    @ConfigurationProperties(prefix = "hbase.config.property")
    public static class PropertiesConfig {

        /**
         * 配置属性的key
         */
        private Map<String, String> propertyKey;

        /**
         * 配置属性的value
         */
        private Map<String, String> propertyValue;


        public Map<String, String> getConfiguration() {
            if (Objects.isNull(propertyKey) || Objects.isNull(propertyValue) || propertyKey.isEmpty() || propertyValue.isEmpty()) {
                log.warn("hbase properties配置为空");
                return Collections.emptyMap();
            }
            HashMap<String, String> properties = new HashMap<>(propertyKey.size());
            propertyKey.forEach((key, value) -> {
                String s = propertyValue.get(key);
                if (!StringUtils.isBlank(s)) {
                    properties.put(value, s);
                }
            });
            return properties;
        }

    }

}
