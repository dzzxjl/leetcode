package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P572 {


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s.left == null && t.left != null) {
            return false;
        }
        if (t.left == null && s.left != null) {
            return false;
        }
        if (s.right == null && t.right != null) {
            return false;
        }
        if (t.right == null && s.right != null) {
            return false;
        }
        if ((s == null && t != null) || (s != null && t == null) || (s.val != t.val)) {
            return false;
        }

        return (isSameTree(s.left, t.left)) && (isSameTree(s.right,t.right));

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node  = new TreeNode(0);


        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(2);

        node4.left = node;

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;


        node6.left = node7;
        node6.right = node8;


        new P572().isSubtree(node1, node6);

    }
}
