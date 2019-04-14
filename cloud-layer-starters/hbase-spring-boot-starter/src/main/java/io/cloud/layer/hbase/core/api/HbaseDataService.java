package io.cloud.layer.hbase.core.api;

import org.apache.hadoop.hbase.client.Result;

/**
 * 对数据的操作
 * @author RippleChan
 * @date 2019-04-11 00:47
 */
public interface HbaseDataService {

    /**
     * 新增带version
     *
     * @param tableName
     * @param familyName
     * @param rowKey
     * @param columnName
     * @param value
     * @param version
     */
    void put(String tableName, String familyName, String rowKey, String columnName, Long version, String value);


    /**
     * 更新前进行检查
     *
     * @param tableName
     * @param familyName
     * @param rowKey
     * @param columnName
     * @param value
     * @param version
     * @return
     */
    boolean checkAndPut(String tableName, String familyName, String rowKey, String columnName, Long version, String value);


    /**
     * 递增/递减操作
     * @param tableName
     * @param familyName
     * @param rowKey
     * @param columnName
     * @param incrementValue
     * @return
     */
    boolean increment(String tableName, String familyName, String rowKey, String columnName, Long incrementValue);

    /**
     * 获取
     * @param tableName
     * @param familyName
     * @param rowKey
     * @return
     */
    Result get(String tableName, String familyName, String rowKey,String columnName);


}
