package com.dzzxjl.linearlist;

import java.util.Stack;

/**
 * Created by dzzxjl on 2017/10/28.
 */
public class P445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode temp = l1;
        ListNode result = new ListNode(0);

        while (temp != null) {
            s1.push(temp.val);
            temp = temp.next;
        }

        temp = l2;

        while (temp != null) {
            s2.push(temp.val);
            temp = temp.next;
        }
        temp = null;
        int flag = 0;
        int sum;
        while (!s1.empty() && !s2.empty()) {
            int a = s1.pop();
            int b = s2.pop();
            sum = a + b + flag;
            ListNode node;
            if (sum >= 10) {
                flag = 1;
                node = new ListNode(sum - 10);
            } else {
                flag = 0;
                node = new ListNode(sum);
            }
            node.next = result.next;
            result.next = node;
        }

        while (!s1.empty()) {
            int a = s1.pop();
            ListNode node = new ListNode(a);
            node.next = result.next;
            result.next = node;
        }
        while (!s2.empty()) {
            int a = s1.pop();
            ListNode node = new ListNode(a);
            node.next = result.next;
            result.next = node;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node5.next = node6;
        node6.next = node7;


        ListNode temp = addTwoNumbers(node1, node5);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}
