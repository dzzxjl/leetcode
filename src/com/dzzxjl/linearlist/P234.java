package com.dzzxjl.linearlist;

import java.util.Stack;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P234 {


    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }
        ListNode first = head;
        int len = 0;

        while (first != null) {
            first = first.next;
            len++;
        }

        Stack<ListNode> stack = new Stack<>();

        first = head;
        for (int i = 0; i< len / 2; i++) {
            stack.push(first);
            first = first.next;
        }
        ListNode second = first;
        if (len % 2 == 0) {
            while (!stack.empty()) {
                if(stack.pop().val != first.val) {
                    return false;
                }
                first = first.next;
            }

        } else {
            second = second.next;
            while (!stack.empty()) {
                if(stack.pop().val != second.val) {
                    return false;
                }
                second = second.next;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
        new P234().isPalindrome(node1);
    }
}
