package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/10/31.
 */
public class P513 {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue1(root).val;
    }
    public TreeNode findBottomLeftValue1(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
//        if ()
        return getDepth(root.left) >= getDepth(root.right) ? findBottomLeftValue1(root.left) : findBottomLeftValue1(root.right);

    }

    public static int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;

        System.out.println(getDepth(node));
        System.out.println(getDepth(null));


    }
}
