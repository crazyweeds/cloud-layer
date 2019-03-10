package io.cloud.layer.code.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author RippleChan
 * @date 2019-03-10 23:17
 */
public class BeanUtils<T> {

    private static final Gson GSON = new Gson();

    /**
     * 将map转换为bean
     * @param mapList
     * @param aclass
     * @return
     */
    public List<T> maps2Beans(List<Map<String,Object>> mapList,Class<? extends T> aclass) {
        Iterator<Map<String, Object>> iterator = mapList.iterator();
        ArrayList<T> ts = new ArrayList<>(mapList.size());
        while (iterator.hasNext()) {
            Map<String, Object> next = iterator.next();
            T t = this.map2Bean(next, aclass);
            ts.add(t);
        }
        return ts;
    }

    /**
     * 将map转换为bean
     * @param map
     * @param aclass
     * @return
     */
    public T map2Bean(Map<String, Object> map, Class<? extends T> aclass) {
        String s = GSON.toJson(map);
        T t = GSON.fromJson(s, aclass);
        return t;
    }

}
