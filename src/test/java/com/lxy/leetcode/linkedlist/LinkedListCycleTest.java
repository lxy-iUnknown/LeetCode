package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.Constants;
import com.lxy.leetcode.util.ListNodes;
import com.lxy.leetcode.util.NonEmptyIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class LinkedListCycleTest {

    public static final Arguments[] ARGUMENTS = {
            createNonCycle(1),
            createNonCycle(2),
            createNonCycle(1, 2),
            createNonCycle(1, 2, 3, 4, 5, 6),
            createNonCycle(1, 2, 3, 4, 5, 6, 7, 8),
            createNonCycle(0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12),
            createCycle(1),
            createCycle(4),
            createCycle(3, 2),
            createCycle(4, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13),
            createLineAndCycle(
                    new NonEmptyIntArray(1), new NonEmptyIntArray(7)),
            createLineAndCycle(
                    new NonEmptyIntArray(1), new NonEmptyIntArray(7, 8)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2), new NonEmptyIntArray(7)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2), new NonEmptyIntArray(7, 8)),
            createLineAndCycle(
                    new NonEmptyIntArray(1),
                    new NonEmptyIntArray(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2),
                    new NonEmptyIntArray(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2, 3, 4, 5),
                    new NonEmptyIntArray(7)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2, 3, 4, 5),
                    new NonEmptyIntArray(7, 8)),
            createLineAndCycle(
                    new NonEmptyIntArray(1, 2, 3, 4, 5),
                    new NonEmptyIntArray(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17))
    };

    private static Arguments createNonCycle(int first) {
        return createNonCycle(first, Constants.EMPTY_ARRAY_INT);
    }

    private static Arguments createCycle(int first) {
        return createCycle(first, Constants.EMPTY_ARRAY_INT);
    }

    private static ListNode createCycleInternal(int first, int... rest) {
        var list = new ListNodes(first, rest);
        list.end().next = list.head();
        return list.head();
    }

    private static Arguments createNonCycle(int first, int... rest) {
        return Arguments.of(new ListNode(first, rest), null);
    }

    private static Arguments createCycle(int first, int... rest) {
        var head = createCycleInternal(first, rest);
        return Arguments.of(head, head);
    }

    private static Arguments createLineAndCycle(
            NonEmptyIntArray line, NonEmptyIntArray cycle) {
        var list = new ListNodes(line);
        var cycleStart = createCycleInternal(cycle.first(), cycle.rest());
        list.end().next = cycleStart;
        return Arguments.of(list.head(), cycleStart);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void hasCycleTest(ListNode head, ListNode cycleStart) {
        Assertions.assertEquals(cycleStart != null, LinkedListUtil.hasCycle(head));
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void detectCycleTest(ListNode head, ListNode cycleStart) {
        Assertions.assertEquals(cycleStart, LinkedListUtil.detectCycle(head));
    }
}
