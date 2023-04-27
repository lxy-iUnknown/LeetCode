package com.lxy.leetcode.util;

import com.lxy.leetcode.linkedlist.LinkedListUtil;
import com.lxy.leetcode.linkedlist.ListNode;

public class ListNodes {
    private final ListNode head;
    private final ListNode end;

    public ListNodes(NonEmptyIntArray array) {
        this(array.first(), array.rest());
    }

    public ListNodes(int first, int... rest) {
        ListNode head = new ListNode(first);
        ListNode end = head;
        for (int number : rest) {
            end = LinkedListUtil.append(end, number);
        }
        this.head = head;
        this.end = end;
    }

    public ListNode head() {
        return head;
    }

    public ListNode end() {
        return end;
    }
}
