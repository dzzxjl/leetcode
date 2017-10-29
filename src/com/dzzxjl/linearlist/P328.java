package com.dzzxjl.linearlist;

/**
 * Created by dzzxjl on 2017/10/29.
 */
public class P328 {
    public static ListNode oddEvenList(ListNode head) {
        // 增加一个表头节点，方便后续操作
        // 注意是下标，不是val
//
//        ListNode addHead = new ListNode(0);
//        addHead.next = head;



        ListNode p1 = head;
        ListNode p2 = head.next;
        skipPointer(p1, p2);

//        ListNode[] temp = new ListNode[];
        while (p1.next != null) {
            p1 = p1.next;

        }

        p1.next = p2;
        return head;
    }

    public static void skipPointer(ListNode a, ListNode b) {
        if ( b== null ||b.next == null) {
            a.next = null;
            return;
        }
        a.next = b.next;
        if (a.next.next != null) {
            b.next = a.next.next;
        } else {
            b.next = null;
        }


        skipPointer(a.next, b.next);
//        return new ListNode[] {a, b};
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
//        ListNode node6 = new ListNode(7);
//        ListNode node7 = new ListNode(8);

        node.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        oddEvenList(node);

        ListNode temp = node;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
