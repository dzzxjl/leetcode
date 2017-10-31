package com.dzzxjl.tree;

import java.util.Map;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P563 {

    public static int sum;
//    public static int tilt;

    public static int findTilt(TreeNode root) {
        getSum(root);
        return sum;
//        if (root == null) {
//            return 0;
//        }
//
//        sum = 0;
//        int leftSum =getSum(root.left);
//        sum = 0;
//        int righSum =getSum(root.right);
//        tilt = tilt + Math.abs(leftSum - righSum);
//        findTilt(root.left);
//        findTilt(root.right);
//        return tilt;
    }


    public static int getSum(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = getSum(root.left);
        int right = getSum(root.right);

        sum = sum + Math.abs(left - right);

        return left + right + root.val;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        node3.right = node4;

        node1.left = node2;


        System.out.println(findTilt(node1));
    }

}
