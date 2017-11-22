package com.dzzxjl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/11/4.
 */
public class P173 {



}

//
//public class BSTIterator {
//    List<TreeNode> list;
//    int index = 0;
//
//    public BSTIterator(TreeNode root) {
//        list = new ArrayList<>();
//        travelTheTree(root);
//    }
//
//    public void travelTheTree(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        travelTheTree(root.left);
//        list.add(root);
//        travelTheTree(root.right);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !list.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return list.get(index++).val;
//    }
//}
