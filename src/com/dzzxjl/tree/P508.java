package com.dzzxjl.tree;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * Created by dzzxjl on 2017/10/31.
 */
public class P508 {
    static Map<Integer,Integer> map = new HashMap<>();
    public static int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> x : map.entrySet()) {
            int temp = x.getValue();
            if ( temp > max) {
                max = temp;
            }
//            System.out.println(x.getKey());
        }

        for (Map.Entry<Integer,Integer> x : map.entrySet()) {
            if(x.getValue() == max) {
                result.add(x.getKey());
            }
        }
        int[] lastResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            lastResult[i] = result.get(i);
        }

        return lastResult;
    }

    public static int sum(TreeNode node) {
//        if (node.left == null && node.right == null) {
//            return node.val;
//        }
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int sum = leftSum + rightSum + node.val;
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum)+1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(-3);
//        node.left = node1;
//        node.right = node2;
        for (Integer x: findFrequentTreeSum(node)) {
            System.out.println(x);
        }
//        findFrequentTreeSum(node);
    }
}
