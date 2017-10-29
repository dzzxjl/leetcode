package com.dzzxjl.string;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P537 {
    public static String complexNumberMultiply(String a, String b) {
        StringBuilder result = new StringBuilder();
        int[] ints = getInt(a);
        int[] ints1 = getInt(b);

        int temp = ints[0] * ints1[0] - ints[1] * ints1[1];

        result.append( temp + "+");

        temp = ints[0] * ints1[1] + ints[1] * ints1[0];


        result.append(temp + "i");
        return result.toString();

    }

    public static int[] getInt(String str) {
        int c, d;
        String[] temp = str.split("\\+");

        StringBuilder temp1 = new StringBuilder(temp[0]);
        StringBuilder temp2 = new StringBuilder(temp[1]);

        if (temp[0].charAt(0) == '-') {
            temp1.deleteCharAt(0);
            c = - Integer.parseInt(temp1.toString());
        } else {
            c = Integer.parseInt(temp1.toString());
        }
        if (temp[1].charAt(0) == '-') {
            temp2.deleteCharAt(0);
            int len = temp[1].length();
            temp2.deleteCharAt(len - 2);
            d = - Integer.parseInt(temp2.toString());
        } else {
            int len = temp[1].length();
            temp2.deleteCharAt(len - 1);
            d = Integer.parseInt(temp2.toString());
        }
        return new int[] {c, d};
    }

    public static void main(String[] args) {
        String a = "1+-1i";
        String b ="1+-1i";
        for (int i : getInt(a)){
            System.out.println(i);
        }

        System.out.println(complexNumberMultiply(a, b));
    }

}
