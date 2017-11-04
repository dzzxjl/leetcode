package com.dzzxjl.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P451 {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();


        int max = 0;
        Character c = 'a';

        int flag = 0;
        while (flag < map.size()) {
            for (Map.Entry<Character, Integer> temp : map.entrySet()) {
                if (temp.getValue() > max) {
                    c = temp.getKey();

                    max = temp.getValue();
                }
            }
            int times = map.get(c);
            while (times > 0) {
                sb.append(c);
                times--;
            }
            map.put(c, 0);

            flag++;
            max = 0;
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(new P451().frequencySort("raaeaedere"));

    }
}
