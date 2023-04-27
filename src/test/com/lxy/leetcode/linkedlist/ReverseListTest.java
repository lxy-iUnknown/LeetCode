package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseListTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(1, 2), new ListNode(2, 1)),
                Arguments.of(new ListNode(1, 2, 3), new ListNode(3, 2, 1)),
                Arguments.of(new ListNode(1, 2, 3, 4), new ListNode(4, 3, 2, 1)),
                Arguments.of(new ListNode(1, 2, 3, 4, 5), new ListNode(5, 4, 3, 2, 1)),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6), new ListNode(6, 5, 4, 3, 2, 1)),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 7), new ListNode(7, 6, 5, 4, 3, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void reverseListTest(ListNode head, ListNode expected) {
        LinkedListTestUtil.assertEquals(expected, ReverseList.reverseList(head));
    }
}
