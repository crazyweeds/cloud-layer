package io.cloud.layer.code;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.service.impl.TableServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author RippleChan
 * @date 2019-03-11 00:03
 */
public class TableServiceImplTest {

    private TableServiceImpl tableService = new TableServiceImpl();

    @Test
    public void getTableInfosByKeyWordTest() {
        List<TableInfo> code = tableService.getTableInfosByKeyWord("code", "%");
        for (int i = 0; i < code.size(); i++) {
            TableInfo tableInfo = code.get(i);
            System.out.println(tableInfo);
        }
    }

}
