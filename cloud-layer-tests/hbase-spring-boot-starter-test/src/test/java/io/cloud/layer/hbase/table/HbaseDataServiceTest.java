package io.cloud.layer.hbase.table;

import io.cloud.layer.hbase.HbaseApplication;
import io.cloud.layer.hbase.core.api.HbaseDataService;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author RippleChan
 * @date 2019-04-18 00:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HbaseApplication.class)
public class HbaseDataServiceTest {

    @Autowired
    private HbaseDataService hbaseDataService;

    @Test
    public void test() {
        String tableName = "users";
        ResultScanner scan = hbaseDataService.scan(tableName);
        Iterator<Result> iterator = scan.iterator();
        while (iterator.hasNext()) {
            Result next = iterator.next();
            byte[] value = next.getValue(Bytes.toBytes("profile"), Bytes.toBytes("name"));
            if (Objects.isNull(value)) {
                break;
            }
            String s = new String(value, StandardCharsets.UTF_8);
            System.out.println(s);
            throw new RuntimeException("test");
        }
    }

}
