package com.example.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map util
 */
public class MapUtil {


    static Map<String, Integer> items = new HashMap<>();

    {
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
    }

    /**
     * forEach
     *
     * @param map
     */
    private void ForEach01(Map map) {

        map.forEach((k, v) -> System.out.println("key : " + k + ", value : " + v));

    }

    /**
     * keySet
     *
     * @param map
     */
    private void ForEach02(Map map) {
        Iterator it = map.keySet().iterator();
        Object key;
        Object value;
        while (it.hasNext()) {
            key = it.next();
            value = map.get(key);
            System.out.println(key + ":" + value);
        }

    }

    /**
     * entrySet
     *
     * @param map
     */
    private void ForEach03(Map map) {
        Iterator it = map.entrySet().iterator();
        Object key;
        Object value;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            key = entry.getKey();
            value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    public static void main(String[] args) {
        MapUtil mapUtil = new MapUtil();
        mapUtil.ForEach01(items);
//        mapUtil.ForEach02(items);
//        mapUtil.ForEach03(items);
    }
}
