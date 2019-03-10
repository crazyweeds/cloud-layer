package io.cloud.layer.code.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author RippleChan
 * @date 2019-03-10 09:21
 */
public class SqlUtils {


    /**
     * 将sql中用$开头的字段替换
     * @param sql
     * @param parameters
     * @return
     */
    public static String getSql(String sql, Map<String,String> parameters) {
        String finalSql = null;
        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            key = "$" + key;
            String value = next.getValue();
            finalSql = sql.replace(key, value);
        }
        if (StringUtils.isBlank(finalSql) || finalSql.contains("$")) {
            throw new RuntimeException("缺少足够的SQL参数");
        }
        return finalSql;
    }

    public static String getSql(String serviceName) {
        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("sql-mysql.properties");
            return properties.getProperty(serviceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
