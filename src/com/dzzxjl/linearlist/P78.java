package com.dzzxjl.linearlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P78 {

    List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {
        for (int x : nums) {
            List<Integer> list = new ArrayList<>();
            // 把当前元素，即这一个元素加入集合
            list.add(x);
            lists.add(list);
            int size = lists.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(lists.get(i));
                temp.add(x);
                lists.add(temp);

            }
        }
        return lists;
    }


    public static void main(String[] args) {

    }
}
