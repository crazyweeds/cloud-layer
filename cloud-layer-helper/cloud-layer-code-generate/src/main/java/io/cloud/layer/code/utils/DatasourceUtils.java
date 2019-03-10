package io.cloud.layer.code.utils;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author RippleChan
 * @date 2019-03-10 08:55
 */
public class DatasourceUtils {

    private static final DriverManagerDataSource dataSource = new DriverManagerDataSource();

    @SuppressWarnings("ALL")
    public static DriverManagerDataSource getDataSource() {
        Properties properties = getProperties();
        dataSource.setDriverClassName(properties.getProperty("class"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }

    private static Properties getProperties() {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("datasource.properties");
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
