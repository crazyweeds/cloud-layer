package io.cloud.layer.hbase.impl.service;

import io.cloud.layer.hbase.core.api.HbaseTableService;
import io.cloud.layer.hbase.impl.exceptions.HbaseOperationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author RippleChan
 * @date 2019-04-11 21:53
 */
@Service("hbaseTableService")
@Slf4j
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
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean create(TableDescriptor tableDescriptor) {
        Admin admin = null;
        try {
            admin = connection.getAdmin();
            admin.createTable(tableDescriptor);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean disable(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            admin.disableTable(TableName.valueOf(tableName));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean enable(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            admin.enableTable(TableName.valueOf(tableName));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean drop(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            admin.deleteTable(TableName.valueOf(tableName));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean alter(TableDescriptor tableDescriptor) {
        boolean exist = this.exist(tableDescriptor.getTableName().toString());
        if (exist) {
            try {
                Admin admin = connection.getAdmin();
                admin.modifyTable(tableDescriptor);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean exist(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            return admin.tableExists(TableName.valueOf(tableName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public TableDescriptor describe(String tableName) {
        try {
            Admin admin = connection.getAdmin();
            TableDescriptor descriptor = admin.getDescriptor(TableName.valueOf(tableName));
            return descriptor;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }

    @Override
    public boolean truncateTable(String tableName,boolean preserveSplits) {
        try {
            Admin admin = connection.getAdmin();
            admin.truncateTable(TableName.valueOf(tableName), preserveSplits);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new HbaseOperationException("操作异常");
    }


}
