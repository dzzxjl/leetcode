package com.dzzxjl.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dzzxjl on 2017/11/1.
 */
public class P623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        if (d == 1) {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            return temp;
        }
        int c = d - 1;
        // 找到c层的所有节点

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // 队列中存放c层所有节点
        queue.add(root);
//        while (!queue.isEmpty() && depth < d - 1) {
        while (!queue.isEmpty() && depth < c - 1) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        while (!queue.isEmpty()) {
//            System.out.println(queue.poll().val);
            TreeNode node = queue.poll();
            if (node.left != null) {
                TreeNode node1 = new TreeNode(v);
                node1.left = node.left;
                node.left = node1;
            } else {
                TreeNode node1 = new TreeNode(v);
                node.left = node1;
            }

            if (node.right != null) {
                TreeNode node1 = new TreeNode(v);
                node1.right = node.right;
                node.right = node1;
            } else {
                TreeNode node1 = new TreeNode(v);
                node.right = node1;
            }
        }

        return root;


    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;


        new P623().addOneRow(node1,5,4);


    }


}
