package com.dzzxjl.string;

/**
 * Created by dzzxjl on 2018/1/25.
 */
public class P13 {

    public int romanToInt(String s) {
        return Integer.parseInt(s);
    }



    public static void main(String[] args) {
        Integer i = new P13().romanToInt("123");
        System.out.printf("" + i);
    }
}
