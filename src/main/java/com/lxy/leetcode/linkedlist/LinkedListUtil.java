package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.CycleDetector;
import com.lxy.leetcode.util.ILinkedNode;

public class LinkedListUtil {
    /**
     * 检测链表是否有环（参见{@link CycleDetector#detect(ILinkedNode)}）
     *
     * @param head 链表表头
     * @return 链表是否有环
     */
    public static boolean hasCycle(ListNode head) {
        return CycleDetector.detect(new ListLinkedNode(head)) != null;
    }

    /**
     * 检测链表是否有环，若有环则返回环起始位置，否则返回null<br>
     * 首先使用快慢指针法找出快慢指针相遇位置（参见{@link CycleDetector#detect(ILinkedNode)}），
     * 用一个指针指向相遇位置。然后再用一个指针指向链表表头，两指针相遇处即为链表环起始位置
     *
     * @param head 链表表头
     * @return 链表环起始位置（没有环则返回null）
     */
    public static ListNode detectCycle(ListNode head) {
        var nodeValue = CycleDetector.detect(new ListLinkedNode(head));
        if (nodeValue == null) {
            return null;
        }
        var node = nodeValue.value;
        var p = head;
        while (p != node) {
            p = p.next;
            node = node.next;
        }
        return p;
    }

    public static int length(ListNode head) {
        var length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static void ensureNotCircular(ListNode head) {
        if (hasCycle(head)) {
            throw new IllegalArgumentException("Linked list has cycle");
        }
    }

    public static ListNode append(ListNode node, int value) {
        var temp = new ListNode(value);
        node.next = temp;
        return temp;
    }

    public static ListNode reverseList(ListNode head) {
        ensureNotCircular(head);
        var p = head;
        var q = head.next;
        while (q != null) {
            var temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head.next = null;
        return p;
    }

    private record ListLinkedNode(ListNode value) implements ILinkedNode<ListLinkedNode> {

        @Override
        public boolean equals(ListLinkedNode other) {
            return value == other.value;
        }

        @Override
        public ListLinkedNode next() {
            return new ListLinkedNode(value.next);
        }

        @Override
        public boolean isNull() {
            return value == null;
        }
    }
}
