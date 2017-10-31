package com.dzzxjl.nocat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P412 {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (Integer i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (String x : new P412().fizzBuzz(15) ){
            System.out.println(x);
        }
    }

}
