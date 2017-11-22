package com.dzzxjl.string;

/**
 * Created by dzzxjl on 2017/11/22.
 */
public class P680 {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int len = s.length();
//        if (len == 2) {
//            return s.charAt(0) == s.charAt(1);
//        }
        int i = 0;
        int j = len -1;
        while (!((i==j) || (i + 1 ==j))) {
            if (s.charAt(i) != s.charAt(j)) {
//                return isPalindrome(removeCharAt(s, i)) || isPalindrome(removeCharAt(s, j));
                return isPalindrome(s.substring(i+1, j+1)) || isPalindrome(s.substring(i, j));
            }
            i++;
            j--;
        }

        return true;
    }

    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int len = s.length();
        if (len == 2) {
            return s.charAt(0) == s.charAt(1);
        }
        int i = 0;
        int j = len -1;
        while (!((i==j) || (i + 1 ==j))) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }


    public static void main(String[] args) {
        String a = "eccer";
//        System.out.println(new P680().isPalindrome(a));
        System.out.println(new P680().validPalindrome(a));
        System.out.println(a.substring(1,3));
    }
}
