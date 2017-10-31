package com.dzzxjl.linearlist;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int a = nums.length;
        int b = nums[0].length;
        int len = a * b;
        if (r * c != len ) {
            return nums;
        }
        int[] all = new int[len];
        int[][] result = new int[r][c];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++){
                all[i*b + j] = nums[i][j];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++){
//                all[i*a + j] = nums[i][j];
                result[i][j] = all[i*c + j];
            }
        }

        return result;


    }


    public static void main(String[] args) {
        int[][] nums ={{1}, {2}, {3}, {4}};
        new P566().matrixReshape(nums, 2, 2);
    }
}
