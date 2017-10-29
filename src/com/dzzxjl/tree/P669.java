package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        TreeNode temp = new TreeNode(root.val);
        temp.left = trimBST(root.left, L, R);
        temp.right = trimBST(root.right, L, R);

        return temp;


    }

    public static void main(String[] args) {

    }
}
