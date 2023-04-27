package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.NonEmptyIntArray;

public final class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
        this(0, (ListNode) null);
    }

    public ListNode(int val) {
        this(val, (ListNode) null);
    }

    public ListNode(ListNode next) {
        this(0, next);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int first, int... rest) {
        this.val = first;
        ListNode node = this;
        for (int number : rest) {
            node = LinkedListUtil.append(node, number);
        }
    }

    public ListNode(NonEmptyIntArray array) {
        this(array.first(), array.rest());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode{val=").append(val).append(", next=");
        if (next == null) {
            sb.append("null");
        } else {
            sb.append(next.val);
        }
        return sb.append('}').toString();
    }
}