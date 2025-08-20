package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class RemoveNthFromEndTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new ListNode(1, 2, 3, 4, 5, 6, 7),
                    1, new ListNode(1, 2, 3, 4, 5, 6)),
            Arguments.of(
                    new ListNode(1, 2, 3, 4, 5, 6, 7),
                    3, new ListNode(1, 2, 3, 4, 6, 7)),
            Arguments.of(
                    new ListNode(1, 2, 3, 4, 5, 6, 7),
                    5, new ListNode(1, 2, 4, 5, 6, 7)),
            Arguments.of(
                    new ListNode(1, 2, 3, 4, 5, 6, 7),
                    7, new ListNode(2, 3, 4, 5, 6, 7)),
            Arguments.of(new ListNode(1), 1, null)
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void removeNthFromEndList(ListNode head, int n, ListNode expected) {
        LinkedListTestUtil.assertEquals(expected, RemoveNthFromEnd.removeNthFromEnd(head, n));
    }
}
