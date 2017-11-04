package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P540 {

    public int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println( 5 ^ 5 ^ 7);
    }
}
