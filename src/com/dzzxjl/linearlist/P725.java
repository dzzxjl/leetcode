package com.dzzxjl.linearlist;

/**
 * Created by dzzxjl on 2017/11/24.
 */
public class P725 {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] result = new ListNode[k];

        if (root == null) {
            return result;
        }

        // get the length
        ListNode temp = root;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }



        temp = root;
        ListNode next = root;
        if (length < k) {
            int i = 0;
            while (next != null) {
                next = temp.next;
                temp.next = null;
                result[i] = temp;
                temp = next;
                i++;
            }
            return result;

        }
//        length > k
        int temp1 = length / k;
        int temp2 = length % k;

        if (temp2 == 0) {
            // 存的正好
            int i = 0;
            while (temp != null) {
                result[i] = temp;
                int j = 0;
                while (j < temp1) {
                    if (j + 1 == temp1) {
                        next = temp.next;
                        temp.next = null;
                        temp = next;
                    } else {
                        next = temp.next;
                        temp = next;
                    }
                    j++;
                }
                i++;
            }
        } else {
//            temp2 < k
//            前temp2个元组每个元组的数据多存放一个
            int temp3 = temp1 + 1;
            int flag = 0;
            int i = 0;
            while (temp != null) {
                result[i] = temp;
                int j = 0;
                if (flag < temp2) {
                    while (j < temp3) {
                        if (j + 1 == temp3) {
                            next = temp.next;
                            temp.next = null;
                            temp = next;
                        } else {
                            next = temp.next;
                            temp = next;
                        }
                        j++;
                    }
                    i++;
                } else {
                    while (j < temp1) {
                        if (j + 1 == temp1) {
                            next = temp.next;
                            temp.next = null;
                            temp = next;
                        } else {
                            next = temp.next;
                            temp = next;
                        }
                        j++;
                    }
                    i++;
                }
                flag++;
            }

        }





        return result;
    }


    public static void main(String[] args) {


    }

}
