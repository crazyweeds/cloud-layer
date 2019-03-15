package io.cloud.layer.code.service.impl;

import com.mysql.cj.MysqlType;
import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.BeanModel;
import io.cloud.layer.code.service.TableService;
import io.cloud.layer.code.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
        System.err.println(beanModel);
        return beanModel;
    }

    private BeanModel maps2BeanModel(List<Map<String, Object>> maps,TableInfo tableInfo) {
        BeanModel beanModel = BeanModel.builder()
            .tableName(tableInfo.getTableName())
            .beanComments(this.getBeanComments(tableInfo))
            .classAnnotations(this.getClassAnnotations(tableInfo))
            .className(this.getClassName(tableInfo))
            .uid(this.getUid())
            .build();
        beanModel.setFields(this.getFields(maps));
        beanModel.setJdkImports(this.jdkImports(maps));
        beanModel.setOtherImports(this.otherImports(maps));
        return beanModel;
    }

    private List<String> otherImports(List<Map<String, Object>> maps) {
        ArrayList<String> imports = new ArrayList<>();
        maps.forEach(map -> {
            String jdbcType = map.get("jdbcType") + "";
            MysqlType byName = MysqlType.getByName(jdbcType);
            String className = byName.getClassName();
            imports.add(className+";");
        });
        imports.add("lombok.AllArgsConstructor;");
        imports.add("lombok.Builder;");
        imports.add("lombok.Data;");
        imports.add("lombok.NoArgsConstructor;");
        imports.add("lombok.experimental.Accessors;");
        imports.add("org.hibernate.validator.constraints.NotEmpty;");
        imports.add("javax.persistence.GeneratedValue;");
        imports.add("javax.persistence.GenerationType;");
        imports.add("javax.persistence.Id;");
        imports.add("javax.persistence.Table;");
        imports.add("java.time.LocalDateTime;");
        return imports;
    }

    private List<String> jdkImports(List<Map<String, Object>> maps) {
        ArrayList<String> imports = new ArrayList<>();

        return null;
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
            String javaType = this.getJavaType(jdbcType);
            BeanModel.Field field = BeanModel.Field.builder()
                .columnName(columnName)
                .isId(this.isKey(isKey))
                .jdbcType(jdbcType)
                .javaType(javaType)
                .length(this.getLength(length))
                .comment(comment)
                .annotations(annotations)
                .property(CamelUtils.formatFieldName("",columnName,"","_"))
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
     * @return
     */
    private String getJavaType(String jdbcType) {
        MysqlType mysqlType = MysqlType.getByName(jdbcType);
        if (Objects.equals(mysqlType, MysqlType.DATETIME)) {
            mysqlType = MysqlType.DATE;
        }
        String[] split = mysqlType.getClassName().split("\\.");
        return split[split.length - 1];
    }


    private List<String> getFieldAnnotations(String isKey, String idStrategy, String isNullAble) {
        List<String> annotations = new ArrayList<>();
        if (StringUtils.equals(isKey, "1")) {
            annotations.add("@Id");
        }
        if (idStrategy.contains("auto_increment") && StringUtils.equals(isKey, "1")) {
            annotations.add("@GeneratedValue(strategy = GenerationType.IDENTITY, generator = \"Mysql\")");
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
        String format = CamelUtils.formatClassName("", tableInfo.getTableName(), "", "_");
        return format;
    }

    /**
     * 获取类的注解信息
     * @return
     */
    private List<String> getClassAnnotations(TableInfo tableInfo) {
        List<String> annotations = new ArrayList<>();
        annotations.add("@Data");
        annotations.add("@Builder");
        annotations.add("@NoArgsConstructor");
        annotations.add("@AllArgsConstructor");
        annotations.add("@Accessors(chain = true)");
        annotations.add("@Table(name=\"" + tableInfo.getTableName() + "\")");
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





































