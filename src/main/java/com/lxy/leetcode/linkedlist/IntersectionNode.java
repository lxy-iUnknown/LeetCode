package com.lxy.leetcode.linkedlist;

public class IntersectionNode {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode a = headA, b = headB;
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
            for (int i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
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
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
