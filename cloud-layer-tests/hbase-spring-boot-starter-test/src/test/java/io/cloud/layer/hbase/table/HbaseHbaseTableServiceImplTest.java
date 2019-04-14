package io.cloud.layer.hbase.table;

import io.cloud.layer.hbase.HbaseApplication;
import io.cloud.layer.hbase.core.api.HbaseTableService;
import io.cloud.layer.hbase.core.model.HbaseTable;
import io.cloud.layer.hbase.impl.service.HbaseTableServiceImpl;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 对 {@link HbaseTableServiceImpl} 中的方法进行测试
 * @author RippleChan
 * @date 2019-04-11 23:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HbaseApplication.class)
public class HbaseHbaseTableServiceImplTest {

    @Autowired
    private HbaseTableService hbaseTableService;

    /**
     * 获取所有表
     */
    @Test
    public void list() {
        List<TableDescriptor> list = hbaseTableService.list();
        list.forEach(tableDescriptor -> {
            TableName tableName = tableDescriptor.getTableName();
            System.out.println(tableName.toString());
        });
    }

    /**
     * 创建表
     */
    @Test
    public void create() {
        ArrayList<String> families = new ArrayList<>();
        families.add("test_cm");
        HbaseTable table = HbaseTable.builder().tableName("test_create").tableFamilies(families).build();
        boolean b = hbaseTableService.create(table);
        Assert.assertTrue(b);
    }

    
    public void disable() {
    }

    
    public void enable() {
    }

    
    public void drop() {
    }

    
    public void alter() {
    }

    
    public void exist() {
    }

    
    public void describe() {

    }

    
    public void count() {

    }

}
