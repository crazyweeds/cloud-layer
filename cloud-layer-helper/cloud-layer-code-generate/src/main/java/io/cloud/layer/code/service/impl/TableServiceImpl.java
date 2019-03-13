package io.cloud.layer.code.service.impl;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.BeanModel;
import io.cloud.layer.code.service.TableService;
import io.cloud.layer.code.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-10 19:04
 */
public class TableServiceImpl implements TableService {


    /**
     * 获取表信息
     * @param database
     * @param tableName
     * @return
     */
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
        System.err.println(sql);
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        BeanUtils<TableInfo> beanUtils = new BeanUtils<>();
        List<TableInfo> tableInfos = beanUtils.maps2Beans(maps, TableInfo.class);
        return tableInfos;
    }

    /**
     * 获取字段信息
     * @param tableInfo
     * @return
     */
    @Override
    public BeanModel getBeanByTableName(TableInfo tableInfo) {
        JdbcTemplate jdbcTemplate = DatasourceUtils.getJdbcTemplate();
        String sql = SqlUtils.getSql("getBeanBydatabaseNameAndTableName");
        Map<String, String> parameters = SqlUtils.getParameters("databaseName", tableInfo.getDatabaseName(), "tableName", tableInfo.getTableName());
        String s = SqlUtils.generateSql(sql, parameters);
        System.err.println(s);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(s);
        BeanModel beanModel = this.maps2BeanModel(maps,tableInfo);
        System.out.println(beanModel);
        return beanModel;
    }

    private BeanModel maps2BeanModel(List<Map<String, Object>> maps,TableInfo tableInfo) {
        BeanModel beanModel = BeanModel.builder()
            .tableName(tableInfo.getTableName())
            .beanComments(this.getBeanComments(tableInfo))
            .classAnnotations(this.getClassAnnotations())
            .className(this.getClassName(tableInfo))
            .uid(this.getUid())
            .fields(this.getFields(maps))
            .build();
        return beanModel;
    }

    /**
     * 获取Field列表
     * @param maps
     * @return
     */
    private List<BeanModel.Field> getFields(List<Map<String, Object>> maps) {
        List<BeanModel.Field> fields = new ArrayList<>();
        maps.forEach(map -> {
            String columnName = map.get("columnName") + "";
            String isNullAble = map.get("isNullAble") + "";
            String jdbcType = map.get("jdbcType") + "";
            String isKey = map.get("isKey") + "";
            String length = map.get("length") + "";
            String comment = map.get("comment") + "";
            String idStrategy = map.get("idStrategy") + "";
            List<String> annotations = this.getFieldAnnotations(isKey,idStrategy,isNullAble);
            String javaType = this.getJavaType(jdbcType, length);
            BeanModel.Field field = BeanModel.Field.builder()
                .columnName(columnName)
                .isId(this.isKey(isKey))
                .jdbcType(jdbcType)
                .javaType(javaType)
                .length(this.getLength(length))
                .comment(comment)
                .annotations(annotations)
                .build();
            fields.add(field);
        });
        return fields;
    }

    private Integer getLength(String length) {
        if (StringUtils.isBlank(length) || StringUtils.equals("null", length)) {
            return 0;
        }
        return Integer.parseInt(length);
    }

    /**
     * 是否是主键
     * @param isKey
     * @return
     */
    private Boolean isKey(String isKey) {
        if (StringUtils.equals(isKey, "1")) {
            return true;
        }
        return false;
    }

    /**
     * todo
     * https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-type-conversions.html
     * @param jdbcType
     * @param length
     * @return
     */
    private String getJavaType(String jdbcType, String length) {
        return "String";
    }

    private List<String> getFieldAnnotations(String isKey, String idStrategy, String isNullAble) {
        List<String> annotations = new ArrayList<>();
        if (StringUtils.equals(isKey, "1")) {
            annotations.add("@Id");
        }
        if (idStrategy.contains("auto_increment") && StringUtils.equals(isKey, "1")) {
            annotations.add("@Geneueaueoaueoa");
        }
        if (StringUtils.equals("NO", isNullAble)) {
            annotations.add("@NotNull");
        }
        return annotations;
    }

    /**
     * 获取系列化
     *
     * @return
     */
    private String getUid() {
        return TextUtils.getSerialVersionUID();
    }

    /**
     * 获取类名
     *
     * @param tableInfo
     * @return
     */
    private String getClassName(TableInfo tableInfo) {
        String format = CamelUtils.format("", tableInfo.getTableName(), "", "_");
        return format;
    }

    /**
     * 获取类的注解信息
     * @return
     */
    private List<String> getClassAnnotations() {
        List<String> annotations = new ArrayList<>();
        annotations.add("@Data");
        return annotations;
    }

    /**
     * todo 还有作者信息等
     * 获取类注释
     * @param tableInfo
     * @return
     */
    private List<String> getBeanComments(TableInfo tableInfo) {
        ArrayList<String> beanComments = new ArrayList<>();
        beanComments.add(tableInfo.getTableComment());
        return beanComments;
    }


}





































