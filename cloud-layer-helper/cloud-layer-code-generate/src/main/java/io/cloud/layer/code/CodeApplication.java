package io.cloud.layer.code;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.*;
import io.cloud.layer.code.service.impl.TableServiceImpl;
import io.cloud.layer.code.utils.CamelUtils;
import io.cloud.layer.code.utils.TemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author RippleChan
 * @date 2019-03-09 16:24
 */
@Slf4j
public class CodeApplication {

    /**
     * 务必保证数据库存在，而且是全称
     */
    private final static String DATABASE;
    /**
     * 支持模糊，可以为空，但不能为null
     */
    private final static String TABLENAME;

    private final static String POJO_FILE_PATH;

    private static final TableServiceImpl tableService = new TableServiceImpl();
    private static final String PACKAGE_NAME;

    static {
        DATABASE = "code";
        TABLENAME = "%";
        PACKAGE_NAME = "io.cloud.layer.code";
        POJO_FILE_PATH = "/Users/chenruibo/Documents/develop/code/cloud-layer/cloud-layer-helper/cloud-layer-code-generate/src/main/resources/";
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
            /**
             * 生成pojo
             */
            BeanModel beanModel = pojo(tableInfo);
            /**
             * 生成Service
             */
            service(beanModel,tableInfo);
            /**
             * 生成ServiceImpl
             */
            serviceImpl(beanModel, tableInfo);
            /**
             * 生成MapperJava
             */
            mapperJava(beanModel, tableInfo);
            /**
             * 生成MapperXml
             */
            mapperXml(beanModel, tableInfo);
        });
    }



    /**
     * 生成POJO
     * @param tableInfo
     */
    private static BeanModel pojo(TableInfo tableInfo) {
        BeanModel beanModelByTableName = tableService.getBeanByTableName(tableInfo);
        beanModelByTableName.setPackageName(PACKAGE_NAME);
        File file = new File(POJO_FILE_PATH + CamelUtils.formatClassName("", tableInfo.getTableName(), "", "_") + ".java");
        try {
            FileWriter fileWriter = new FileWriter(file);
            TemplateUtils.process("bean.ftl", beanModelByTableName, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return beanModelByTableName;
    }

    /**
     * 生成Service
     *
     * @param tableInfo
     */
    private static void service(BeanModel beanModel, TableInfo tableInfo) {
        String className = CamelUtils.formatClassName("", tableInfo.getTableName() + "Service", "", "_");
        File file = new File(POJO_FILE_PATH + className + ".java");
        ServiceModel serviceModel = new ServiceModel();
        BeanUtils.copyProperties(beanModel, serviceModel);
        try {
            FileWriter fileWriter = new FileWriter(file);
            TemplateUtils.process("service.ftl", serviceModel, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成ServiceImpl
     * @param beanModel
     * @param tableInfo
     */
    private static void serviceImpl(BeanModel beanModel, TableInfo tableInfo) {
        String className = CamelUtils.formatClassName("", tableInfo.getTableName() + "ServiceImpl", "", "_");
        File file = new File(POJO_FILE_PATH + className + ".java");
        ServiceModel serviceModel = new ServiceModelImpl();
        BeanUtils.copyProperties(beanModel, serviceModel);
        try {
            FileWriter fileWriter = new FileWriter(file);
            TemplateUtils.process("serviceImpl.ftl", serviceModel, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成MapperJava
     * @param beanModel
     * @param tableInfo
     */
    private static void mapperJava(BeanModel beanModel, TableInfo tableInfo) {
        String className = CamelUtils.formatClassName("", tableInfo.getTableName() + "Mapper", "", "_");
        File file = new File(POJO_FILE_PATH + className + ".java");
        ServiceModel serviceModel = new MapperJava();
        BeanUtils.copyProperties(beanModel, serviceModel);
        try {
            FileWriter fileWriter = new FileWriter(file);
            TemplateUtils.process("mapperJava.ftl", serviceModel, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成MapperXml
     * @param beanModel
     * @param tableInfo
     */
    private static void mapperXml(BeanModel beanModel, TableInfo tableInfo) {
        String className = CamelUtils.formatClassName("", tableInfo.getTableName() + "Mapper", "", "_");
        File file = new File(POJO_FILE_PATH + className + ".xml");
        ServiceModel serviceModel = new MapperXml();
        BeanUtils.copyProperties(beanModel, serviceModel);
        try {
            FileWriter fileWriter = new FileWriter(file);
            TemplateUtils.process("mapperXml.ftl", serviceModel, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
