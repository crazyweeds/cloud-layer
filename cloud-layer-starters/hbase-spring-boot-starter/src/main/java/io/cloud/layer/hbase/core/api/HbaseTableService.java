package io.cloud.layer.hbase.core.api;

import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.shaded.protobuf.generated.MasterProtos;

import java.util.List;

/**
 * 表相关的操作
 * 对 {@link org.apache.hadoop.hbase.client.Admin} 的封装
 * 全部操作可以查看： {@link MasterProtos}
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
     * @param tableDescriptor
     * @return
     */
    boolean create(TableDescriptor tableDescriptor);

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
     * @param tableDescriptor
     * @return
     */
    boolean alter(TableDescriptor tableDescriptor);

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
     * 清空表数据
     * @param tableName
     * @return
     */
    boolean truncateTable(String tableName,boolean preserveSplits);



}
