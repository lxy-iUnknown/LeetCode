package com.lxy.leetcode.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">删除链表的倒数第 N 个结点</a>
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        var p = head;
        var q = head;
        for (var i = 1; i <= n; i++) {
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
