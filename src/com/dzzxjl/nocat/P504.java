package com.dzzxjl.nocat;

import java.util.Stack;

/**
 * Created by dzzxjl on 2017/11/3.
 */
public class P504 {

    public String convertToBase7(int num) {

        if (num < 0) {
            return "-" + fun(num);
        } else {
            return fun(num);
        }

    }
    public String fun(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num / 7 != 0) {
            int temp = num % 7;
            stack.push(temp);
            System.out.println(num % 7);
            num = num / 7;
        }
        stack.push(num);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }



    public static void main(String[] args) {

        int num = 59;
        while (num / 7 != 0) {
            int temp = num % 7;
            System.out.println(num % 7);
            num = num / 7;
        }
        System.out.println(num);


    }
}
