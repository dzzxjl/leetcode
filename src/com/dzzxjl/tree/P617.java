package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return t2;
        } else if (t1 != null && t2 == null) {
            return t1;
        } else if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }

    public static void main(String[] args) {

    }
}
