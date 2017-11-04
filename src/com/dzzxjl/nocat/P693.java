package com.dzzxjl.nocat;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P693 {

    public boolean hasAlternatingBits(int n) {

        int flagOld = n % 2;
        int flagNew = (n / 2) % 2;

        while (n != 0 && flagOld != flagNew) {
            flagNew = n % 2;
            System.out.println(n % 2);
            n = n / 2;

        }

        if (flagNew == flagOld) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new P693().hasAlternatingBits(8);



    }

}
