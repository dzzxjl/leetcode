package com.dzzxjl.linearlist;

import java.util.Arrays;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P575 {

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int result = 1;
        int flag = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] != flag) {
                result++;
                flag = candies[i];
            }
        }
        if (result > candies.length/2 ) {
            return candies.length/2;
        } else {
            return result;
        }

    }


    public static void main(String[] args) {
        System.out.println(new P575().distributeCandies(new int[]{1, 1,  2,  3}));
    }

}
