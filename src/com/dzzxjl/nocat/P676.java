package com.dzzxjl.nocat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P676 {


}


class MagicDictionary {

//    ArrayList<String> list;
    Map<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
//        list = new ArrayList<String>();
        map = new HashMap<Integer, ArrayList<String>>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
//            list.add(s);
            int len = s.length();
            if (map.containsKey(len)) {
                map.get(len).add(s);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(len, temp);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        ArrayList<String> list = map.get(len);
        for (String s : list) {
            int error = 0;
            int index = 0;
            while (error < 2) {
                if (word.charAt(index) == s.charAt(index) ) {

                } else {
                    error++;
                }

            }
            if (error < 1) {
                return true;
            }
        }
        return false;
    }
}


