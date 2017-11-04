package com.dzzxjl.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c , 1);
            }
        }


        for (int j = 0; j < ransomNote.length(); j++) {
            Character c = ransomNote.charAt(j);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                map.put(c , -1);
            }
        }


        for (Map.Entry<Character, Integer> temp : map.entrySet()) {
            if (temp.getValue() < 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {


    }


}
