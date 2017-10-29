package com.dzzxjl.string;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P557 {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        String[] temp = s.split(" ");
        for (String x : temp) {
            result.append(" " + new StringBuilder(x).reverse());
        }
        result.deleteCharAt(0);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
