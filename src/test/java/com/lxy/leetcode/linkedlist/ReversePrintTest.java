package com.lxy.leetcode.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class ReversePrintTest {

    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new ListNode(1),
                    new int[]{1}),
            Arguments.of(new ListNode(1, 2, 3),
                    new int[]{3, 2, 1}),
            Arguments.of(new ListNode(1, 2, 3, 4, 5),
                    new int[]{5, 4, 3, 2, 1}),
            Arguments.of(new ListNode(1, 2, 3, 4, 5, 6, 7, 8),
                    new int[]{8, 7, 6, 5, 4, 3, 2, 1})
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void reversePrintTest(ListNode head, int[] expected) {
        Assertions.assertArrayEquals(expected, ReversePrint.reversePrint(head));
    }
}
