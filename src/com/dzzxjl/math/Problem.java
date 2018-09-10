package com.dzzxjl.math;

/**
 * Created by dzzxjl on 2018/9/6.
 */
public class Problem {

    public static int convertPQ(int num1, int num2) {
        int result = 0;

        result = num1 ^ num2;

        int count = 0;
        while(result!= 0){
            count++;
            result = result & (result - 1);
        }
//        return count;
        return count;

    }

    public static void main(String[] args) {

        System.out.println(convertPQ(8,82));
    }
}
