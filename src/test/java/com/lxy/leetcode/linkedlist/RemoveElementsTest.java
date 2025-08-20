package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class RemoveElementsTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new ListNode(1, 2, 6, 3, 4, 5, 6),
                    6, new ListNode(1, 2, 3, 4, 5)),
            Arguments.of(null, 1, null),
            Arguments.of(new ListNode(6, 1, 2, 6, 3, 3, 5, 4, 5, 6),
                    6, new ListNode(1, 2, 3, 3, 5, 4, 5)),
            Arguments.of(new ListNode(6, 6, 6, 6, 6, 6),
                    6, null),
            Arguments.of(new ListNode(5, 6, 6, 6, 6, 6),
                    6, new ListNode(5))
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void removeElementsTest(ListNode head, int val, ListNode expected) {
        LinkedListTestUtil.assertEquals(expected, RemoveElements.removeElements(head, val));
    }
}
