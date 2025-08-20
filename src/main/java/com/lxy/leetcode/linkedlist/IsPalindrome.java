package com.lxy.leetcode.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">回文链表</a>
 */
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        var slow = head;
        var fast = head;
        var count = 0;
        // Find middle node of list
        while (fast != null && fast.next != null) {
            // fast is faster than slow, so slow must be non-null
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        // Reverse second part of list
        fast = LinkedListUtil.reverseList(slow);
        slow = head;
        for (var i = 0; i < count; i++) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
