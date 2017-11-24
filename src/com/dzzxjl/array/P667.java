package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/24.
 */
public class P667 {

    public int[] constructArray(int n, int k) {
        // 1 <= k < n
        // 给这n的数排一个顺序
        int[] result = new int[n];

        //k=1
//        if (k == 1) {
//
//        }
        int i = 0, left = 1, right = n;
        while (i < k) {
            result[i++] = left++;
            if (i < k) {
                result[i++] = right--;
            }
        }
        // 偶数
        if (k % 2 == 0) {
            while (i < result.length) result[i++] = right--;
        } else { // 奇数
            while (i < result.length) result[i++] = left++;
        }
        return result;


    }


    public static void main(String[] args) {
        System.out.println(new P667().constructArray(6, 3));
//        for (Integer i : new P667().constructArray(6, 3)) {
//            System.out.println(i);
//        }
    }
}
