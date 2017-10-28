package com.dzzxjl.test;

/**
 * Created by dzzxjl on 2017/7/12.
 */
public class SayGoodbye {
    public static String SayHello(String boyName, String girlName) {
        return "a new begin";
    }
    public static String SayGoodbye() {
        return "yongyuanbujian";
    }
    public static String SayGoodbye(String anyOneName) {
        return "yongyuanbujian";
    }

    public static void main(String[] args) {
        System.out.println(SayHello("yang","daibi"));
        System.out.println(SayGoodbye());
    }
}
