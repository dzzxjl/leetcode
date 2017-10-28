package com.dzzxjl.test;

/**
 * Created by dzzxjl on 2017/7/7.
 */
public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}
