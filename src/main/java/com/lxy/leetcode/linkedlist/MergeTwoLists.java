package com.lxy.leetcode.linkedlist;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        ListNode p = list1, q = list2;
        while (p != null && q != null) {
            ListNode temp;
            if (p.val < q.val) {
                temp = p;
                p = p.next;
            } else {
                temp = q;
                q = q.next;
            }
            node.next = temp;
            node = temp;
        }
        node.next = p == null ? q : p;
        return dummy.next;
    }
}
