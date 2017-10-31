package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/10/31.
 */
public class P55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int index = 0;
        while ( index + nums[index] < len - 1) {
            if (nums[index] == 0) {
                return false;
            }
            int flag = index + 1;
            int max = index + 1 + nums[flag];
            for (int i = index + 2; i <= index + nums[index]; i++) {
                if (nums[i] + i >= max) {
                    max = nums[i] + i;
                    flag = i;
                }
            }
            if (max == 0) {
                return false;
            }
            index = flag;
        }
        return true;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,1,1,4};
        int[] nums = new int[]{1,1,2,2,0,1,1};
//        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(new P55().canJump(nums));
    }
}
