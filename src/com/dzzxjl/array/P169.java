package com.dzzxjl.array;

import java.util.Arrays;

/**
 * Created by dzzxjl on 2017/11/4.
 */
public class P169 {


    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1 || len == 2) {
            return nums[0];
        }
        int times = len / 2;


        Arrays.sort(nums);

        int major = nums[0];
        int temp = 1;
        for (int i = 0; i + 1 < times + 1; i++) {
//        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i + 1] == nums[i]) {
                temp++;
            } else {
                if (temp > times){
                    return major;
                }
                major = nums[i + 1];
                temp = 1;
            }
        }


        return major;



    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
//        int[] nums = new int[]{7,7,7,7,7,3,5,3,3,8,3,6,7,7};

        System.out.println(new P169().majorityElement(nums));

    }

}
