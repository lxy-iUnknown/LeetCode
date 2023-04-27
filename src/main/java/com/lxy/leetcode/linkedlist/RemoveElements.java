package com.lxy.leetcode.linkedlist;

public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0 /* invalid */);
        dummy.next = head;
        ListNode prev = dummy, next = head;
        while (next != null) {
            if (next.val == val) {
                prev.next = next.next;
            } else {
                prev = next;
            }
            next = next.next;
        }
        return dummy.next;
    }
}
