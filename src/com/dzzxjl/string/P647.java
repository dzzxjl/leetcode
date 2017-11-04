package com.dzzxjl.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P647 {


    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        List<String> result = new ArrayList<>();

        int  len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String temp = s.substring(i, j + 1);
                if (isPal(temp)) {
                    result.add(temp);
                }
            }
        }
        return result.size();

    }


    public boolean isPal(String str) {
        int len = str.length();
        if (len == 1) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int k = 0; k < len / 2; k++) {
            stack.push(str.charAt(k));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());

        }
        if (len % 2 == 0) {
            return sb.toString().equals(str.substring(len / 2, len));
        } else {
            return sb.toString().equals(str.substring((len / 2) + 1, len));
        }

    }


    public static void main(String[] args) {


        String str = "aaa";
        System.out.println(new P647().countSubstrings(str));
    }
}
