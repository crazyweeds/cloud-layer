package io.cloud.layer.code.service;

import io.cloud.layer.code.datamodel.Bean;

/**
 * @author RippleChan
 * @date 2019-03-10 19:04
 */
public interface TableService {

    /**
     * 根据表明获取表信息
     * @param tableName
     * @return
     */
    Bean getBeanByTableName(String tableName);

}
