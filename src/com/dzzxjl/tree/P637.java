package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        double average = 0;
        double sum = 0;
        int size = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            average = sum / size;

            result.add(average);
        }

        return result;

    }

    public static void main(String[] args) {

    }

}
