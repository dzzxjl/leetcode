package com.dzzxjl.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P389 {

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (tMap.containsKey(c)) {
                tMap.put(c, tMap.get(c) + 1);
            } else {
                tMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {

            if (sMap.get(entry.getKey()) != entry.getValue()) {
                return entry.getKey();
            }
            if (!sMap.containsKey(entry.getKey())) {
                return entry.getKey();
            }
        }

        return 'd';
    }


    public static void main(String[] args) {


    }
}
