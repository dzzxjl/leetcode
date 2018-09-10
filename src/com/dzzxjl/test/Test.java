package com.dzzxjl.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dzzxjl on 2017/4/4.
 */
public class Test {

    Class  A = new Test().getClass();
//        public static class InnerClass {
//            public InnerClass() {
//                System.out.println("创建InnerClass");
//            }
//        }
    public class InnerClass {
        public InnerClass() {
            System.out.println("创建InnerClass");
        }
        Class a = getClass();
    }

    public static void main(String[] args) {
//            Object.getClass()
//        Test test = new Test();
//        InnerClass a = test. new InnerClass();
//        InnerClass b = test. new InnerClass();
//
//        String str = "hello";
//        str.length()
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        List<Integer> newList = list;
//        list.add(4);
//        for (Integer i : newList) {
//            System.out.println(i);
//        }

//        List<Integer> infoList1 = new ArrayList<>();
//        List<Integer> infoList1Copy = new ArrayList<>();
//
//        for (Integer x : infoList1)
//            infoList1Copy.add(x);
//        }
    }
}
