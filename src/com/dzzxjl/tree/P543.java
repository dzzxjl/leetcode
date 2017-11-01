package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/11/1.
 */
public class P543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        max = maxDepth(root) + maxDepth(root.right);
        return max;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        max = Math.max(max, leftDepth + rightDepth);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {


    }
}
