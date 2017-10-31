package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P653 {

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
//        if (root.val > k ) {
//            return findTarget(root.left, k);
//        }

        ArrayList<Integer> rightList = new ArrayList<>();
        rightList.add(root.val);

        getRight(root.right, k, rightList);

        ArrayList<Integer> AnotherList = new ArrayList<>();
        for (int x : rightList) {
            AnotherList.add(k - x);
        }


        return find(root.left, k ,AnotherList);
    }

    public static void getRight(TreeNode root, int k, ArrayList rightList) {
        if (root == null) {
            return;
        }

            rightList.add(root.val);
            getRight(root.left, k, rightList);
            getRight(root.right, k, rightList);

    }
    public static boolean find(TreeNode root, int k, ArrayList<Integer> object) {
        if (root == null) {
            return false;
        }
        int temp = root.val;
        for (Integer x: object) {
            if (x == temp) {
                return true;
            }
        }
        return find(root.left, k, object) && find(root.left, k, object);
    }

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(6);
//        TreeNode node3 = new TreeNode(2);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(7);
//
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.right = node5;


        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(-4);
        TreeNode node4 = new TreeNode(1);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(findTarget(node, -1));
    }
}
