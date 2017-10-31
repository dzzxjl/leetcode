package com.dzzxjl.string;

import java.util.Stack;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P682 {
    public int calPoints(String[] ops) {
        int result = 0;
        if (ops.length == 0) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++ ) {
            String x = ops[i];
            if(x.equals("C")) {
                stack.pop();
            } else if(x.equals("D")) {
                stack.push(2 * stack.peek());
            } else if(x.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else {
                stack.push(Integer.parseInt(x));
            }
        }
        while (!stack.isEmpty()){
            result = result + stack.pop();

        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"5","-2","4","C","D","9","+","+"};

        System.out.println(new P682().calPoints(input));
    }
}
