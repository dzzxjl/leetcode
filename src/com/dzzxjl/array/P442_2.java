package com.dzzxjl.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P442_2 {

    public List<Integer> findDuplicates(int[] nums) {
//        int len = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i : nums) {
            if (i < 0) {
                i = -i;
                if (nums[i - 1] < 0) {
                    list.add(i);
                }
                nums[i-1] = -nums[i-1];

            } else {
                if (nums[i - 1] < 0) {
                    list.add(i);
                }
                nums[i-1] = -nums[i-1];
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        new P442_2().findDuplicates(nums);
    }

}
