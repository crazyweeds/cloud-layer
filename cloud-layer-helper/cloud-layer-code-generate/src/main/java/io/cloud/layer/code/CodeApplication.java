package io.cloud.layer.code;

import io.cloud.layer.code.utils.DatasourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-09 16:24
 */
public class CodeApplication {

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from COLUMNS;");
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> map = maps.get(i);
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                String key = next.getKey();
                Object value = next.getValue();
                System.out.println(key + ":" + value);
            }
            System.out.println("------------------");
        }
    }

}
