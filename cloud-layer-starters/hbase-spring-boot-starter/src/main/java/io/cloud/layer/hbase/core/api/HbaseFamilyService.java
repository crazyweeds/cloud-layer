package io.cloud.layer.hbase.core.api;

/**
 * 操作 column
 * @author RippleChan
 * @date 2019-04-11 00:29
 */
public interface HbaseFamilyService {

    /**
     * 删除列族
     * @param tableName
     * @param family
     * @return
     */
    boolean delete(String tableName, String family);

}
