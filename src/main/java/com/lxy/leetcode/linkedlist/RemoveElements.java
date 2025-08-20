package com.lxy.leetcode.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">移除链表元素</a>
 */
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        var dummy = new ListNode(0 /* invalid */);
        dummy.next = head;
        var prev = dummy;
        var next = head;
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
