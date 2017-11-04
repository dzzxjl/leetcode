package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P485 {


    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if(nums[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

//        int flag = 1;
        int max = 0;
        int max2 = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                max2++;
            } else {
                if (max2 > max) {
                    max = max2;
                }
                while (nums[i] != 1 && i < nums.length - 1) {
                    i++;
                }
                if (nums[i] == 0) {

                } else {
                    i--;
                }

                max2 = 0;
            }
            i++;
        }


        return max > max2 ? max : max2;


    }
//    public int findMaxConsecutiveOnes(int[] nums) {


//        int flag = nums[0];
//        int flag = 1;
//        int max = 1;
//        int max2 = 0;
//        int i = 0;
//        while (i < nums.length) {
//            if (nums[i] == flag) {
//              max2++;
//            } else {
//                flag = nums[i];
//                if (max2 > max) {
//                    max = max2;
//                }
//                max2 = 1;
//            }
//            i++;
//        }


//        return max > max2 ? max : max2;


//    }


    public static void main(String[] args) {

        int[] nums = {0, 0};
//        int[] nums = {1,0,1,1,0,1};

        System.out.println(new P485().findMaxConsecutiveOnes(nums));


    }

}
