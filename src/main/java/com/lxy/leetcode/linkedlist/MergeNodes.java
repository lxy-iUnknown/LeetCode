package com.lxy.leetcode.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros/">合并零之间的节点</a>
 */
public class MergeNodes {
    public static ListNode mergeNodes(ListNode head) {
        var p = head.next;
        var q = p;
        var sum = 0;
        while (q != null) {
            var value = q.val;
            if (value != 0) {
                // Accumulate sum
                sum += value;
                q = q.next;
            } else {
                // Reset sum
                p.val = sum;
                sum = 0;
                // Link to next non-zero node
                var next = q.next;
                p.next = next;
                q = next;
                p = q;
            }
        }
        // Return the node after head node
        return head.next;
    }
}
