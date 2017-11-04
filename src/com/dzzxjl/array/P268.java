package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/4.
 */
public class P268 {

    public int missingNumber(int[] nums) {
        // 排除数组长度为1的情况
        if (nums.length == 1) {
            return nums.length - nums[0];
        }
        int flag = -99999;;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]);

            if (temp == nums.length || temp == flag ) {

            } else if (temp == 0) {
                nums[0] = -999;
            } else {
                if (nums[temp] == 0) {
                    nums[0] = -1;
                    nums[temp] = -temp;
                    flag = temp;

                } else {
                    nums[temp] = - nums[temp];
                }

            }

        }

        for (int i = 0; i < nums.length; i++) {

//            这个地方>=怎么设置
            if (nums[i] >= 0) {
                return i;
            }
        }
        return nums.length;
    }



    public static void main(String[] args) {


//        int[] nums = new int[]{0,2};
        int[] nums = new int[]{1,0};
//        int[] nums = new int[]{0,1};
//        int[] nums = new int[]{2,0};
//        int[] nums = new int[]{2,0,1};
        System.out.println(new P268().missingNumber(nums));
    }
}
