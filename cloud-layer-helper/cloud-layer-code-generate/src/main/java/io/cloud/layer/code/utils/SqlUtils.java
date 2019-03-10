package io.cloud.layer.code.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author RippleChan
 * @date 2019-03-10 09:21
 */
@Slf4j
public class SqlUtils {


    /**
     * 将sql中用$开头的字段替换
     * @param sql
     * @param parameters
     * @return
     */
    public static String getSql(String sql, Map<String,String> parameters) {
        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            key = "$" + key;
            String value = next.getValue();
            sql = sql.replace(key, value);
        }
        if (StringUtils.isBlank(sql) || sql.contains("$")) {
            log.error("sql:{}", sql);
            log.error("parameters:{}", parameters);
            throw new RuntimeException("缺少足够的SQL参数");
        }
        return sql;
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

    /**
     * String[] 转换为 Map
     *
     * @param parameters
     * @return
     */
    public static Map<String, String> getParameters(String... parameters) {
        if (parameters.length % 2 != 0) {
            throw new RuntimeException("参数数量有误");
        }
        HashMap<String, String> map = new HashMap<>(parameters.length / 2);
        for (int i = 0; i < parameters.length / 2; i++) {
            map.put(parameters[i * 2], parameters[i * 2 + 1]);
        }
        return map;
    }

}
