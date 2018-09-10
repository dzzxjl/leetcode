package com.dzzxjl.test;

/**
 * Created by dzzxjl on 2017/12/16.
 */
public class A {

    A(){

        System.out.println(A.class);
    }
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getClass());
//        Class.getResouces
    }
}
