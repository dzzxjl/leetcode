package com.dzzxjl.nocat;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by dzzxjl on 2017/11/23.
 */
public class P728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        if (left > right) {
            return result;
        }

        Integer i = left;
        while (i <= right ) {
            if (isDividingNumbers(i)) {
                result.add(i);
            }
            i++;
        }

        return result;
    }

    public boolean isDividingNumbers(Integer num) {
        String temp = num.toString();
        Stack<Integer> stack = new Stack<>();
        for (Character c : temp.toCharArray()) {
            int i = Integer.parseInt(c.toString());
            if (i == 0) {
                return false;
            } else {
                stack.push(i);
            }

        }
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (num % i != 0){
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new P728().isDividingNumbers(22322));
    }

}
