package com.lxy.leetcode.linkedlist;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">相交链表</a>
 */
public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var lengthA = 0;
        var lengthB = 0;
        var a = headA;
        var b = headB;
        while (a != null && b != null) {
            lengthA++;
            lengthB++;
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            lengthA++;
            a = a.next;
        }
        while (b != null) {
            lengthB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (lengthA > lengthB) {
            for (var i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        } else {
            for (var i = 0; i < lengthB - lengthA; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    // https://zhuanlan.zhihu.com/p/476656641
    public static ListNode getIntersectionNodeSimple(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        var a = headA;
        var b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
