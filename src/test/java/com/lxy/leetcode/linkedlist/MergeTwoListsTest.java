package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class MergeTwoListsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(
                    new ListNode(1),
                    new ListNode(1),
                    new ListNode(1, 1)),
            Arguments.of(
                    new ListNode(1),
                    new ListNode(2),
                    new ListNode(1, 2)),
            Arguments.of(
                    new ListNode(1, 3, 4),
                    new ListNode(1, 4, 5),
                    new ListNode(1, 1, 3, 4, 4, 5)),
            Arguments.of(
                    new ListNode(1, 2, 3),
                    new ListNode(4, 5, 7, 8, 10),
                    new ListNode(1, 2, 3, 4, 5, 7, 8, 10)),
            Arguments.of(
                    new ListNode(1, 3, 5, 7),
                    new ListNode(2, 4, 6, 8),
                    new ListNode(1, 2, 3, 4, 5, 6, 7, 8)),
            Arguments.of(
                    new ListNode(1, 3, 6, 9, 10, 12, 17, 27),
                    new ListNode(0, 2, 4, 5, 18, 19, 22, 23, 24),
                    new ListNode(0, 1, 2, 3, 4, 5, 6, 9, 10, 12, 17, 18, 19, 22, 23, 24, 27))
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void mergeTwoListsTest(ListNode list1, ListNode list2, ListNode expected) {
        LinkedListTestUtil.assertEquals(expected, MergeTwoLists.mergeTwoLists(list1, list2));
    }
}
