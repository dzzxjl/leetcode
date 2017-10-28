package com.dzzxjl.problem;

/**
 * Created by dzzxjl on 2017/10/28.
 */

public class P654 {


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return getTheTree(0, nums.length - 1, nums);
    }

    public static TreeNode getTheTree(int a, int b, int[] nums) {
        // a与b为传进来的下标
        if (a > b) {
            return null;
        }
        int max = nums[a];
        int flag = a;
        for (int i = 1; i < b - a + 1; i++) {
            if ( nums[a + i] > max) {
                max = nums[a + i];
                flag = a + i;
            }
        }
        TreeNode node = new TreeNode(nums[flag]);

        node.left = getTheTree(a, flag - 1, nums);
        node.right = getTheTree(flag + 1, b, nums);
        return node;
    }

    public static void bianli(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.val);
        bianli(node.left);
        bianli(node.right);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode temp = constructMaximumBinaryTree(nums);
        bianli(temp);
    }



}
