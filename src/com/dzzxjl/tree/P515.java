package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.poll().val;
            for(int i = 0; i < size - 1; i++) {
                TreeNode node = queue.poll();
                 int temp = node.val;
                 if(temp > max) {
                     max = temp;
                 }
                 if (node.left != null) queue.offer(node.left);
                 if (node.right != null) queue.offer(node.right);
            }
            result.add(max);
        }


        return result;
    }

    public static void main(String[] args) {

    }
}
