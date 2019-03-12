package io.cloud.layer.code.service.impl;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.BeanModel;
import io.cloud.layer.code.service.TableService;
import io.cloud.layer.code.utils.BeanUtils;
import io.cloud.layer.code.utils.DatasourceUtils;
import io.cloud.layer.code.utils.SqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-10 19:04
 */
public class TableServiceImpl implements TableService {


    @Override
    public List<TableInfo> getTableInfosByKeyWord(String database, String tableName) {
        if (StringUtils.isBlank(tableName)) {
            tableName = "";
        }
        if (StringUtils.isBlank(database)) {
            throw new RuntimeException("缺失数据库名称");
        }
        Map<String, String> parameters = SqlUtils.getParameters("tableName", tableName, "database", database);
        String originalSql = SqlUtils.getSql("getTableInfosByKeyWord");
        String sql = SqlUtils.generateSql(originalSql, parameters);
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        BeanUtils<TableInfo> beanUtils = new BeanUtils<>();
        List<TableInfo> tableInfos = beanUtils.maps2Beans(maps, TableInfo.class);
        return tableInfos;
    }

    @Override
    public BeanModel getBeanByTableName(String database, String tableName) {
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        String sql = SqlUtils.getSql("getBeanByTableName");
        Map<String, String> parameters = SqlUtils.getParameters("databaseName", database, "tableName", tableName);
        String s = SqlUtils.generateSql(sql, parameters);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(s);
        return null;
    }


}
