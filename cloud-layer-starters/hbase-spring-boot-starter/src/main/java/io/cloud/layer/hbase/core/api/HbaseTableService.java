package io.cloud.layer.hbase.core.api;

import io.cloud.layer.hbase.core.model.HbaseTable;
import org.apache.hadoop.hbase.client.TableDescriptor;

import java.util.List;

/**
 * 表相关的操作
 * @author RippleChan
 * @date 2019-04-11 00:29
 */
public interface HbaseTableService {

    /**
     * 列出所有表
     * @return
     */
    List<TableDescriptor> list();

    /**
     * 创建表
     * @param hbaseTable
     * @return
     */
    boolean create(HbaseTable hbaseTable);

    /**
     * 禁用表
     * @param tableName
     * @return
     */
    boolean disable(String tableName);

    /**
     * 启用表
     * @param tableName
     * @return
     */
    boolean enable(String tableName);


    /**
     * 删除表
     * @param tableName
     * @return
     */
    boolean drop(String tableName);

    /**
     * 修改表：包括列族、属性，如果不熟悉，请勿轻易调用
     * @param hbaseTable
     * @return
     */
    boolean alter(HbaseTable hbaseTable);

    /**
     * 表是否存在
     * @param tableName
     * @return
     */
    boolean exist(String tableName);

    /**
     * 表属性
     * @param tableName
     * @return
     */
    TableDescriptor describe(String tableName);

    /**
     * 查看表中的数据规模
     * @param tableName
     * @return
     */
    Long count(String tableName);

}
