package io.cloud.layer.hbase.core.api;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

/**
 * 对数据的操作
 * @author RippleChan
 * @date 2019-04-11 00:47
 */
public interface HbaseDataService {

    /**
     * 新增
     * @param tableName 表名
     * @param familyName 列族名称
     * @param rowKey rowKey
     * @param columnName 列名
     * @param value 值
     * @param version 版本，可以为null
     */
    void put(String tableName, String familyName, String rowKey, String columnName, Long version, byte[] value);


    /**
     * 更新前进行检查
     *
     * @param tableName 表名
     * @param familyName 列族名称
     * @param rowKey rowkey
     * @param columnName 列名
     * @param value 值
     * @param version 版本，可以是null
     * @return
     */
    boolean checkAndPut(String tableName, String familyName, String rowKey, String columnName, Long version, byte[] value);


    /**
     * 递增/递减操作
     * @param tableName 表名
     * @param familyName 列族名称
     * @param rowKey rowKey
     * @param columnName 列名
     * @param incrementValue 自增/自减的值
     * @return
     */
    boolean increment(String tableName, String familyName, String rowKey, String columnName, Long incrementValue);

    /**
     * 根据rowKey获取值
     * @param tableName 表名
     * @param familyName 列族名
     * @param rowKey rowKey
     * @return
     */
    Result get(String tableName, String familyName, String rowKey,String columnName);


    ResultScanner scan(String tableName);

}
