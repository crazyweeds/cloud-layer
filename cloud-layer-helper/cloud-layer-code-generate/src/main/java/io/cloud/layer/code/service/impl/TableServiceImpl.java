package io.cloud.layer.code.service.impl;

import io.cloud.layer.code.datamodel.Bean;
import io.cloud.layer.code.service.TableService;
import io.cloud.layer.code.utils.DatasourceUtils;
import io.cloud.layer.code.utils.SqlUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-10 19:04
 */
public class TableServiceImpl implements TableService {


    @Override
    public Bean getBeanByTableName(String tableName) {
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        String sql = SqlUtils.getSql("getBeanByTableName");
        HashMap<String, String> parameters = new HashMap<>(1);
        parameters.put("tableName", tableName);
        String sql1 = SqlUtils.getSql(sql, parameters);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql1);
        return null;
    }

}
