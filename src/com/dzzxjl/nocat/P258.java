package com.dzzxjl.nocat;

import com.dzzxjl.linearlist.P25;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P258 {

    public int addDigits(int num) {
        Integer temp = num;
        String str = temp.toString();
        if (num < 10) {
            return num;
        }
        while (str.length() > 1) {
            str = fun(str);
        }
        return Integer.parseInt(str);
    }


    public String fun(String str) {
        Integer sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = sum + Integer.parseInt(str.charAt(i) + "");
        }
        return sum.toString();
    }


    public static void main(String[] args) {

        System.out.println(new P258().addDigits(38));



    }


}
