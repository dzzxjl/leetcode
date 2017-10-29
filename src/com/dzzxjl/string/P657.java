package com.dzzxjl.string;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P657 {
    public static boolean judgeCircle(String moves) {
        int size = moves.length();
        // 记录上下移动情况
        int flag1 = 0;
        int flag2 = 0;
        for (int i = 0; i< size; i++) {
            char temp = moves.charAt(i);
            if (temp == 'U') {
                flag1++;
            } else if (temp == 'D') {
                flag1--;
            } else if (temp == 'L') {
                flag2++;
            } else if (temp == 'R'){
                flag2--;
            }
        }

        if (flag1 == 0 && flag2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("RLUURDDDLU"));
    }
}
