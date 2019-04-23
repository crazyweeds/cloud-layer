package io.cloud.layer.hbase.impl.service;

import io.cloud.layer.hbase.core.api.HbaseDataService;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * @author RippleChan
 * @date 2019-04-11 21:53
 */
@Service
public class HbaseDataServiceImpl implements HbaseDataService {

    @Autowired
    private Connection connection;


    @Override
    public void put(String tableName, String familyName, String rowKey, String columnName, Long version, byte[] value) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Put put = this.getPut(familyName, rowKey, columnName, value, version);
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkAndPut(String tableName, String familyName, String rowKey, String columnName, Long version, byte[] value) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Table.CheckAndMutateBuilder checkAndMutateBuilder = table.checkAndMutate(Bytes.toBytes(rowKey), Bytes.toBytes(familyName));
            boolean b = checkAndMutateBuilder.ifEquals(value).thenPut(this.getPut(familyName, rowKey, columnName, value, version));
            return b;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean increment(String tableName, String familyName, String rowKey, String columnName, Long incrementValue) {
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Increment increment = new Increment(Bytes.toBytes(rowKey));
            increment.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName), incrementValue);
            table.increment(increment);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Result get(String tableName, String familyName, String rowKey,String columnName) {
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            Result result = table.get(get);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultScanner scan(String tableName) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            ResultScanner scanner = table.getScanner(new Scan());
            return scanner;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Put getPut(String familyName, String rowKey, String columnName, byte[] value, Long version) {
        Put put = new Put(Bytes.toBytes(rowKey));
        if (Objects.isNull(version)) {
            put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName), value);
        } else {
            put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName), version, value);
        }
        return put;
    }

}
