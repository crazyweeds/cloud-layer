package io.cloud.layer.code.service;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.datamodel.BeanModel;

import java.util.List;

/**
 * @author RippleChan
 * @date 2019-03-10 19:04
 */
public interface TableService {

    /**
     * 根据关键字筛选表
     *
     * @param keyWord
     * @return
     */
    List<TableInfo> getTableInfosByKeyWord(String database, String keyWord);

    /**
     * 根据表明获取表信息
     *
     * @param tableInfo
     * @return
     */
    BeanModel getBeanByTableName(TableInfo tableInfo);

}
