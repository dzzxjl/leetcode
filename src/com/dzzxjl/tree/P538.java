package com.dzzxjl.tree;

import com.dzzxjl.linearlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P538 {
    public static TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        LVR(root, list);
        int sum = 0;
        int size = list.size();
        for (int i = size -1; i >= 0; i--) {
            int temp = list.get(i).val;

            list.get(i).val = sum + temp;
            sum = sum + temp;
        }

        return root;
    }
    public static void LVR(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        LVR(node.left, list);
        list.add(node);
        System.out.println(node.val);
        LVR(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(13);

        node.left = node1;
        node.right = node2;
        convertBST(node);

    }
}
