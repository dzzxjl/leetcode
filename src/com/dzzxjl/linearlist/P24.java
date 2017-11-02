package com.dzzxjl.linearlist;

import com.dzzxjl.tree.TreeNode;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }


        ListNode temp = head.next;

        head.next = head.next.next;
        temp.next = head;
        head.next = swapPairs(head.next);

        return temp;


    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);



        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        new P24().swapPairs(node1);
    }
}
