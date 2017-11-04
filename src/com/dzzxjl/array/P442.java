package com.dzzxjl.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P442 {


    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
//        int[] arr = new int[len];
        List<Integer> list = new ArrayList<>();

//        for (int i = 0; i< nums.length; i++) {
////            arr[i]++;
//            if (nums[i] > 0) {
//                nums[i-1] = -nums[i-1];
//            } else {
//                nums
//            }
//
//        }

        for (int i : nums) {
//            arr[i]++;
//            if (nums[i] > 0) {
                nums[i-1] = -nums[i-1];
//            }

        }

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 2) {
//                list.add(i);
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    public static void main(String[] args) {

    }

}
