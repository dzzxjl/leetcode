package com.dzzxjl.linearlist;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P461 {

    public static int hammingDistance(int x, int y) {
//        int miX = 0;
//        int miY = 0;
//
//        while (x / 2 != 0) {
//            miX++;
//            x = x /2;
//        }
//        while (y / 2 != 0) {
//            miY++;
//            y = y /2;
//        }
//
//        return miX > miY ? miX - miY : miY - miX;
        int i = x ^ y;
        int count=0;
        while (i != 0) {
            ++ count;
            i = (i-1)& i;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
