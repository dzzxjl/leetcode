package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getDepth(root.left) - getDepth(root.right)) < 2;
    }


    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);

        return left > right ? left + 1 : right + 1;
    }


    public static void main(String[] args) {

    }
}
