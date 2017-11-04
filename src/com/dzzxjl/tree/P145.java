package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode root, ArrayList<Integer> list) {
        if (root ==  null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);

    }

    public static void main(String[] args) {


    }
}
