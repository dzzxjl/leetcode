package com.dzzxjl.test.maptest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class test {


//    HashMap
    static public class A {

        Integer b;
        Integer a = 0;

        A (Integer b) {
            this.b = b;
        }
//        @Override
//        public int hashCode() {
//            return a.hashCode() ;
//
//        }

//        @Override
//        public boolean equals(Object obj) {
//            if (obj instanceof A) {
//                A temp = (A)obj;
//                if (a == temp.a){
//                    return true;
//                }
//            }
//
//            return false;
//        }
    }
    public static void main(String[] args) {


        Map<A, Integer> map = new HashMap<>();


        A a = new A(1);
        map.put(a, 1);

        A b = new A(1);
        System.out.println(map.containsKey(b));
    }
}
