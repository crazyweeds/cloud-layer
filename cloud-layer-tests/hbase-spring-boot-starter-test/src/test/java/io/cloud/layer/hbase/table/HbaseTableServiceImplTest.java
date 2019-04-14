package io.cloud.layer.hbase.table;

import io.cloud.layer.hbase.HbaseApplication;
import io.cloud.layer.hbase.core.api.HbaseTableService;
import io.cloud.layer.hbase.impl.service.HbaseTableServiceImpl;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 对 {@link HbaseTableServiceImpl} 中的方法进行测试
 * @author RippleChan
 * @date 2019-04-11 23:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HbaseApplication.class)
public class HbaseTableServiceImplTest {

    @Autowired
    private HbaseTableService hbaseTableService;

    
    @Test
    public void list() {
        List<TableDescriptor> list = hbaseTableService.list();
        list.forEach(tableDescriptor -> {
            TableName tableName = tableDescriptor.getTableName();
            System.out.println(tableName.toString());
        });
    }

    
    public void create() {
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
