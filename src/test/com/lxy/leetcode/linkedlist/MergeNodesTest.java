package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.linkedlist.LinkedListTestUtil;
import com.lxy.leetcode.linkedlist.ListNode;
import com.lxy.leetcode.linkedlist.MergeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeNodesTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new ListNode(0, 3, 1, 0, 4, 5, 2, 0),
                        new ListNode(4, 11)),
                Arguments.of(
                        new ListNode(0, 1, 0, 3, 0, 2, 2, 0),
                        new ListNode(1, 3, 4)),
                Arguments.of(
                        new ListNode(0, 4, 1, 3, 0, 2, 4, 0),
                        new ListNode(8, 6)),
                Arguments.of(
                        new ListNode(0, 3, 0, 4, 0, 5, 6, 7, 0, 8, 0),
                        new ListNode(3, 4, 18, 8)),
                Arguments.of(
                        new ListNode(0, 1, 0),
                        new ListNode(1))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void mergeNodesTest(ListNode head, ListNode expected) {
        LinkedListTestUtil.assertEquals(expected, MergeNodes.mergeNodes(head));
    }
}
