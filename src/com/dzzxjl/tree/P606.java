package com.dzzxjl.tree;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P606 {
    public static String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }
        String result = t2str(t);
        int len = result.length();
        return t2str(t).substring(1, len - 1);

    }
    public static String t2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();

        if (t == null) return sb.toString();
        sb.append('(');
        sb.append(t.val);
//        为叶节点
        if (t.left == null && t.right == null) {
            sb.append(")");
            return sb.toString();
        } else {
            if (t.left == null && t.right != null) {
                sb.append("()");
                sb.append(t2str(t.right));

            } else {
                sb.append(t2str(t.left));
                sb.append(t2str(t.right));
            }

        }
         sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.toString());

        //test1
//        TreeNode node = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//
//        node.left = node1;
//        node1.left = node3;
//        node.right = node2;


        //test2
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);

        node.left = node1;
        node1.right = node3;
        node.right = node2;


        System.out.println(tree2str(node));
    }

}
