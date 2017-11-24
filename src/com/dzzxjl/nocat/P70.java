package com.dzzxjl.nocat;

/**
 * Created by dzzxjl on 2017/11/23.
 */
public class P70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n-2) + climbStairs(n -1);



    }

    public static void main(String[] args) {

        System.out.println(new P70().climbStairs(44));

    }
}
