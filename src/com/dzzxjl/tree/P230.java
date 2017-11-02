package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P230 {


    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        Inorder(root);
        return list.get(k - 1);

    }



    public void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        list.add(root.val);
        Inorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
//        new P230().kthSmallest();

    }



}
