package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P35 {


    public int searchInsert(int[] nums, int target) {

        int len = nums.length;
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[len - 1] <= target) {
            return len;
        }
        int i = 0;
        while (nums[i] < target) {
            i++;
        }

        return i;




    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        new P35().searchInsert(nums, 3);
    }

}
