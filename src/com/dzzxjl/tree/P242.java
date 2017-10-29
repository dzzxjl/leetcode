package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/10/27.
 */
public class P242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return true;
        }
        if (t.length() > s.length()) {
            String temp;
            temp = t;
            t = s;
            s = temp;
        }

        int tLen = t.length();
        int sLen = s.length();


//        int i = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                if(s.substring(i, i + tLen).equals(t)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "hello";
        String t = "ell";
        System.out.println(isAnagram(s, t));


        System.out.println('c' - 'a');

    }
}
