package com.dzzxjl.linearlist;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P561 {
    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i = i + 2 ) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(arrayPairSum(nums));
    }
}
