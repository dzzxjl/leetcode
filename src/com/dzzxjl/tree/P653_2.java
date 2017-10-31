package com.dzzxjl.tree;

import java.util.HashSet;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P653_2 {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);


        return findTarget(root.left, k) && findTarget(root.right, k);
    }

    public static void main(String[] args) {

    }
}
