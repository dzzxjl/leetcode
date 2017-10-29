package com.dzzxjl.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dzzxjl on 2017/10/27.
 */
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[0];
        if (nums1.length == 0 || nums2.length == 0)
            return null;

        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
//        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        result = new int[set2.size()];
        int i = 0;
        for (int k : set2) {
            result[i] = k;
        }
//        int k = 0;
//        for (int i = 0; i < nums1.length; i++) {
//            set1.add(nums1[i]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            set2.add(nums2[i]);
//        }
//        for (int i : set1) {
//            for (int j : set2) {
//                if (i == j) {
//                    list.add(i);
//                }
//            }
//        }
//        int[] result = new int[list.size()];
//        for(int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
//        System.out.println(result);
//        for (int i = 0; i< result.length; i++){
//            System.out.println(result[i]);
//        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
