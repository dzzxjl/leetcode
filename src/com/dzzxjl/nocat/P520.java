package com.dzzxjl.nocat;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P520 {



    public boolean detectCapitalUse(String word) {

        if (word.length() == 1) {
            return true;
        }
        char first = word.charAt(0);
        if (first >= 97 && first <= 122) {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 97 || word.charAt(i) > 122) {
                    return false;
                }
            }
        } else {
            char second = word.charAt(1);
            if (second >= 97 && second <= 122) {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) < 97 || word.charAt(i) > 122) {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) < 65 || word.charAt(i) > 90) {
                        return false;
                    }
                }
            }


        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println('a' == 97);
        System.out.println('z' == 122);
        System.out.println('A' == 65);
        System.out.println('Z' == 90);
        System.out.println(new P520().detectCapitalUse("USA"));

    }
}
