package com.dzzxjl.array;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] result = new int[len1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums2[j] == nums1[i]) {
                    int mark = j;
                    while (mark < len2) {
                        if (nums2[mark] > nums1[i]) {
                            result[i] = nums2[mark];
                            break;
                        }
                        mark++;
                    }
                    if (mark == len2) {
                        result[i] = -1;
                    }

                    break;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1,2,3,4};
        for (Integer i: new P496().nextGreaterElement(nums1, nums2)) {
            System.out.println(i);
        }

    }

}
