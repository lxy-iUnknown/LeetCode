package com.lxy.leetcode.linkedlist;

public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        return head == null ? null : LinkedListUtil.reverseList(head);
    }
}