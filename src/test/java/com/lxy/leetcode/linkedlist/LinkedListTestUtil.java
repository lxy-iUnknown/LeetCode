package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.api.Assertions;

public class LinkedListTestUtil {

    public static void assertEquals(ListNode expected, ListNode actual) {
        LinkedListUtil.ensureNotCircular(expected);
        LinkedListUtil.ensureNotCircular(actual);
        var index = 0;
        while (expected != null && actual != null) {
            Assertions.assertEquals(expected.val, actual.val,
                    "Linked list node value at index " + index + " not equal");
            actual = actual.next;
            expected = expected.next;
            index++;
        }
        Assertions.assertEquals(
                LinkedListUtil.length(expected) + index,
                LinkedListUtil.length(actual) + index,
                "Linked list length not equal");
    }
}
