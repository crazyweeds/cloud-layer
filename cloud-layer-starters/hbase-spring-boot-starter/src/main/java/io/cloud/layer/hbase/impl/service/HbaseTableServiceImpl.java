package io.cloud.layer.hbase.impl.service;

import io.cloud.layer.hbase.core.api.HbaseTableService;
import io.cloud.layer.hbase.core.model.HbaseTable;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author RippleChan
 * @date 2019-04-11 21:53
 */
@Service("hbaseTableService")
public class HbaseTableServiceImpl implements HbaseTableService {

    @Autowired
    private Connection connection;

    @Override
    public List<TableDescriptor> list() {
        try {
            Admin admin = connection.getAdmin();
            return admin.listTableDescriptors();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
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
