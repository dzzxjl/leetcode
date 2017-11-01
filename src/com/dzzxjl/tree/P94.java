package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/1.
 */
public class P94 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;


    }

    public static void main(String[] args) {

    }

}
