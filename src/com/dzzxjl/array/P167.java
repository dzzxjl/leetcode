package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/4.
 */
public class P167 {


    public int[] twoSum(int[] numbers, int target) {


        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                left = left + 1;
                right = right + 1;
                result[0] = left;
                result[1] = right;
                return result;
            } else if (temp > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }





//        if (len == 2){
//            return new int[]{1, 2};
//        }
//        int[] result = new int[2];
//
//
//        for (int i = 0; i < len; i++) {
//            if (numbers[i] > target) {
//                break;
//            }
//            for (int j = i + 1; j < len; j++) {
//
//                if (numbers[i] + numbers[j] == target) {
//                    result[0] = i + 1;
//                    result[1] = j + 1;
//                    return result;
//                }
//
//                if (numbers[i] + numbers[j] >= target) {
//                    break;
//                }
//            }
//        }
        return result;
    }




    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 3, 4};
        for (Integer i : new P167().twoSum(nums, 0)) {
            System.out.println(i);
        }

    }
}
