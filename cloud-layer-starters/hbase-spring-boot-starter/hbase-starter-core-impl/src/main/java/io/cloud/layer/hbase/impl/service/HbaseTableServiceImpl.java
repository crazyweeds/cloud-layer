package io.cloud.layer.hbase.impl.service;

import io.cloud.layer.hbase.core.api.HbaseTableService;
import io.cloud.layer.hbase.core.model.HbaseTable;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;

import java.util.List;

/**
 * @author RippleChan
 * @date 2019-04-11 21:53
 */
public class HbaseTableServiceImpl implements HbaseTableService {

    @Override
    public List<Table> list() {
        return null;
    }

    @Override
    public boolean create(HbaseTable hbaseTable) {
        return false;
    }

    @Override
    public boolean disable(String tableName) {
        return false;
    }

    @Override
    public boolean enable(String tableName) {
        return false;
    }

    @Override
    public boolean drop(String tableName) {
        return false;
    }

    @Override
    public boolean alter(HbaseTable hbaseTable) {
        return false;
    }

    @Override
    public boolean exist(String tableName) {
        return false;
    }

    @Override
    public TableDescriptor describe(String tableName) {
        return null;
    }

    @Override
    public Long count(String tableName) {
        return null;
    }

}
