package io.cloud.layer.code;

import io.cloud.layer.code.core.TableInfo;
import io.cloud.layer.code.utils.BeanUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-10 23:26
 */
public class BeanUtilsTest {

    private Map map = null;

    {
        map = new HashMap<>();
        map.put("tableName", "user");
        map.put("tableComment", "用户");
    }

    @Test
    public void test1() {
        BeanUtils<TableInfo> beanUtils = new BeanUtils<>();
        TableInfo tableInfo = beanUtils.map2Bean(map, TableInfo.class);
        System.out.println(tableInfo);
    }

    @Test
    public void test2() {
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        maps.add(map);
        BeanUtils<TableInfo> beanUtils = new BeanUtils<>();
        List<TableInfo> tableInfos = beanUtils.maps2Beans(maps, TableInfo.class);
        for (int i = 0; i < tableInfos.size(); i++) {
            TableInfo tableInfo = tableInfos.get(i);
            System.out.println(tableInfo);
        }
    }

}
