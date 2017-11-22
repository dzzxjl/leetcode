package com.dzzxjl.math;

/**
 * Created by dzzxjl on 2017/11/4.
 */
public class P326 {


    public static boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        if (n < 6) {
            return false;
        }
        return  isPowerOfThree(n / 3);
    }


    public static void main(String[] args) {

        System.out.println(isPowerOfThree(19684));;

    }
}
