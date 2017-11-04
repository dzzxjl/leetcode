package com.dzzxjl.tree;

import java.util.*;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

//        if
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // 第一个元素进队列
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
//                queue.offer(node);
            }
            stack.push(temp);

//            TreeNode node = queue.poll();
//            temp.add(node.val);


        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;

    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        node.left = node1;
        node.right = node2;

        new P107().levelOrderBottom(node);

    }

}
