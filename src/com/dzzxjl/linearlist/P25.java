package com.dzzxjl.linearlist;

import java.util.HashMap;
import java.util.concurrent.TransferQueue;

/**
 * Created by dzzxjl on 2017/11/2.
 */
public class P25 {
    ListNode tail;
    ListNode tail1;

    ListNode last = null;

    int flag = 0;
    int flag2 = 0;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        int i = 0;
        ListNode lastNode = head;
        ListNode preNode = head;
        ListNode temp = head;
        while (lastNode != null) {
            if ((i + 1) % k == 0) {
                ListNode temp1 = lastNode.next;
                if (flag2 == 0) {
                    flag2++;
                } else {
                    temp.next = lastNode;
                }
                temp = reverse(preNode, lastNode.next);
                lastNode = temp1;
                preNode = temp1;
            } else  {
                if (i < k && lastNode.next == null) {
                    return head;
                }
                // lastNode = lastNode.next;
                if (i % k == 0) {
                    last = lastNode;
                }
                lastNode = lastNode.next;
            }
            i++;
        }
        if (i % k == 0) {
            return tail;
        } else {
            temp.next = last;
            return tail;
        }
    }

    /*
    root为起始节点
    obj为最终节点的下一个节点
     */
    public ListNode reverse(ListNode root, ListNode obj) {

        if (root.next == obj) {
            if (flag == 0) {
                tail = root;
                flag++;
            }
            tail1 = root;
            return root;
        }

        ListNode temp = reverse(root.next, obj);
        temp.next = root;
        root.next = null;
        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        new P25().reverseKGroup(node1, 2);

    }

}
