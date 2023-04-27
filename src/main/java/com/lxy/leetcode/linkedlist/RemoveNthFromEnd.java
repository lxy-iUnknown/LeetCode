package com.lxy.leetcode.linkedlist;


public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head;
        for (int i = 1; i <= n; i++) {
            q = q.next;
        }
        if (q == null) {
            // Delete first node
            return head.next;
        } else {
            // Delete other node
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            p.next = p.next.next;
            return head;
        }
    }
}
