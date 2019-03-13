package io.cloud.layer.code;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.BeanModel;
import io.cloud.layer.code.service.impl.TableServiceImpl;
import io.cloud.layer.code.service.impl.TemplateServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author RippleChan
 * @date 2019-03-09 16:24
 */
@Slf4j
public class CodeApplication {

    /**
     * 务必保证数据库存在
     */
    private final static String DATABASE;
    /**
     * like查询的关键词：like %{TABLENAME}%
     */
    private final static String TABLENAME;

    private static final TableServiceImpl tableService = new TableServiceImpl();
    private static final TemplateServiceImpl TemplateServiceImpl = new TemplateServiceImpl();
    private static final String PACKAGE_NAME;

    static {
        DATABASE = "code";
        TABLENAME = "";
        PACKAGE_NAME = "io.cloud.layer.code";
        System.setProperty("PACKAGE_NAME", PACKAGE_NAME);
    }

    /**
     * 1.根据调整查询表 {@link TableInfo}
     * 2.根据表构建 {@link BeanModel}
     * 3.根据 {@link BeanModel} 和模板生成代码
     *      3.1.生成Pojo
     *      3.2.生成Service
     *      3.3.生成ServiceImpl
     *      3.4.生成Mapper.java
     *      3.5.生成Mapper.xml
     *      3.6.生成
     * @param args
     */
    public static void main(String[] args) {
        List<TableInfo> tableInfosByKeyWord = tableService.getTableInfosByKeyWord(DATABASE, TABLENAME);
        int size = tableInfosByKeyWord.size();
        log.info("查询到 {} 张符合条件的表。", size);
        log.info("---------------------tables---------------------->");
        tableInfosByKeyWord.forEach(tableInfo -> log.info(tableInfo.toString()));
        log.info("<---------------------tables----------------------");
        tableInfosByKeyWord.forEach(tableInfo -> {
            log.info("正在查询表信息：{}", tableInfo.toString());
            BeanModel beanModelByTableName = tableService.getBeanByTableName(tableInfo);
        });
    }

}
