package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsPalindromeTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new ListNode(1), true),
                Arguments.of(new ListNode(1, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 2), false),
                Arguments.of(new ListNode(1, 2, 3, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 3, 1), false),
                Arguments.of(new ListNode(1, 2, 3, 4, 4, 3, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 3, 2, 1), false),
                Arguments.of(new ListNode(1, 2, 3, 5, 4, 3, 2, 1), false),
                Arguments.of(new ListNode(0, 2, 3, 4, 4, 3, 2, 1), false),
                Arguments.of(new ListNode(1, 7, 3, 4, 4, 3, 2, 1), false),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1), true),
                Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1), true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isPalindromeTest(ListNode head, boolean expected) {
        Assertions.assertEquals(expected, IsPalindrome.isPalindrome(head));
    }
}
