package com.dzzxjl.nocat;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P477 {


    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int[][] result = new int[len][len];
        int sum = 0;

        for(int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                result[i][j] = fun(nums[i], nums[j]);
                sum = sum + result[i][j];
            }
        }

        return sum;
    }

    public static int fun(int num1, int num2) {
        int result = num1 ^ num2;
        int distance = 0;
        while ((result / 2) != 0) {
            if ((result / 2) == 1) {
                distance++;
            }

            result = result / 2;
        }
        if (result == 1) {
            distance++;
        }
        return distance;

    }


    public static void main(String[] args) {

        System.out.println(fun(1337,7331));
    }
}
