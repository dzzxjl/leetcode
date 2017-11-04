package com.dzzxjl.nocat;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P677 {



}



class MapSum {

    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
       map  = new HashMap<>();

    }

    public void insert(String key, int val) {
//        if (map.containsKey(key)) {
//            map.put(key,val);
//        } else {
            map.put(key, val);
//        }
    }

    public int sum(String prefix) {
        int sum = 0;
        int len = prefix.length();
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            String key = temp.getKey();
            if (key.length() < len) {
//                return 0;
            } else if (temp.getKey().substring(0, prefix.length()).equals(prefix)) {
                sum = sum + temp.getValue();
            }
        }
        return sum;
    }
}
