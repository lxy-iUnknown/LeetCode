package com.lxy.leetcode.linkedlist;

public class LinkedListUtil {


    /**
     * 使用快慢指针法检测链表是否有环，如果有环则返回快慢指针相遇的节点，否则返回null<br>
     * 快慢指针一开始都位于链表头部，快指针走两步，慢指针走一步，
     * 如果无法走动（指针为空）则说明没有环，如果快慢指针相遇则说明有环
     * @param head 链表表头
     * @return 链表是否有环
     */
    private static ListNode detectCycleInternal(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        // 检查快指针是否能继续走动
        while (fast != null && (fast = fast.next) != null) {
            slow = slow.next;
            fast = fast.next;
            // 快慢指针相遇
            if (slow == fast) {
                return slow;
            }
        }
        // 没有环
        return null;
    }

    /**
     * 检测链表是否有环（参见{@link LinkedListUtil#detectCycleInternal(ListNode)}）
     * @param head 链表表头
     * @return 链表是否有环
     */
    public static boolean hasCycle(ListNode head) {
        return detectCycleInternal(head) != null;
    }

    /**
     * 检测链表是否有环，若有环则返回环起始位置，否则返回null<br>
     * 首先使用快慢指针法找出快慢指针相遇位置（参见{@link LinkedListUtil#detectCycleInternal(ListNode)}），
     * 用一个指针指向相遇位置。然后再用一个指针指向链表表头，两指针相遇处即为链表环起始位置
     * @param head 链表表头
     * @return 链表环起始位置（没有环则返回null）
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode node = detectCycleInternal(head);
        if (node == null) {
            return null;
        }
        ListNode p = head;
        while (p != node) {
            p = p.next;
            node = node.next;
        }
        return p;
    }

    public static int length(ListNode head) {
        int length = 0;
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
        ListNode temp = new ListNode(value);
        node.next = temp;
        return temp;
    }

    public static ListNode reverseList(ListNode head) {
        ensureNotCircular(head);
        ListNode p = head, q = head.next;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        head.next = null;
        return p;
    }
}
