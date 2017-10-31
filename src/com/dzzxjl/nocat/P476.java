package com.dzzxjl.nocat;

/**
 * Created by dzzxjl on 2017/10/30.
 */
public class P476 {

    public static int findComplement(int num) {

        int bit = 1;
        int a = num;
        while (a / 2 != 0){
            bit++;
            a = a / 2;
        }

        int temp = 1;
        while (bit != 0) {
            temp*=2;
            bit--;
        }
        temp--;
        int result = num ^ temp;
        return result;
    }

    public static void main(String[] args) {
        int temp = findComplement(5);
        System.out.println(temp);
    }
}
