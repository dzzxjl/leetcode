package com.dzzxjl.linearlist;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return null;
        } else if (head.next.next == null) {
            if (n == 1) {
                head.next = null;
            }
            if (n == 2) {
                head = head.next;
            }
        } else if (head.next.next.next == null) {
            if (n == 1) {
                head.next.next = null;
            }
            if (n == 2) {
                head.next = head.next.next;
            }
            if (n == 3) {
                head = head.next;
            }

        } else {
            if (n == 1) {
                ListNode node1 = head.next;
                ListNode node2 = head;
                while (node1.next != null) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                node2.next = null;

            } else {
                ListNode node1 = head;
                ListNode node2 = head;
                ListNode node3 = head;

                int flag = 0;
                int i = 0;
                while (i < n - 1) {
                    node1 = node1.next;
                    i++;
                }
                if (i + 1 != n) {
                    while (node1.next != null) {

                        node1 = node1.next;
                        node2 = node2.next;
                        if (flag == 1) {
                            node3 = node3.next;
//                    flag = 1;
                        } else {
                            flag++;
                        }

                    }
                    if (node2 == null) {
                        node3.next = null;
                    } else {
                        node3.next = node2.next;
                    }
                } else {
                    head = node3.next;
                }

            }


        }

        return  head;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);



        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;

        new P19().removeNthFromEnd(node1,2);



    }
}
