package com.dzzxjl.linearlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P136 {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        for (Map.Entry x : map.entrySet()) {
            if ((int)x.getValue() == 1) {
                return (int)x.getKey();
            }
        }

        return 0;
    }

    public static int singleNumber2(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,0, 1,1,2};
        int[] nums = new int[]{2, 1, 4, 5, 2, 4, 1};
        System.out.println(singleNumber2(nums, nums.length));
    }
}
