package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.Constants;
import com.lxy.leetcode.util.ListNodes;
import com.lxy.leetcode.util.NonEmptyIntArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class LinkedListCycleTest {

    private record CycledListNodes(ListNode head, ListNode cycleStart) {
    }

    private static CycledListNodes createNonCycle(int first) {
        return createNonCycle(first, Constants.EMPTY_ARRAY_INT);
    }

    private static CycledListNodes createCycle(int first) {
        return createCycle(first, Constants.EMPTY_ARRAY_INT);
    }
    
    private static ListNode createCycleInternal(int first, int... rest) {
        ListNodes list = new ListNodes(first, rest);
        list.end().next = list.head();
        return list.head();
    }

    private static CycledListNodes createNonCycle(int first, int... rest) {
        return new CycledListNodes(new ListNode(first, rest), null);
    }

    private static CycledListNodes createCycle(int first, int... rest) {
        ListNode head = createCycleInternal(first, rest);
        return new CycledListNodes(head, head);
    }

    private static CycledListNodes createLineAndCycle(
            NonEmptyIntArray line, NonEmptyIntArray cycle) {
        ListNodes list = new ListNodes(line);
        ListNode cycleStart = createCycleInternal(cycle.first(), cycle.rest());
        list.end().next = cycleStart;
        return new CycledListNodes(list.head(), cycleStart);
    }

    public static List<CycledListNodes> arguments() {
        return List.of(
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
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void hasCycleTest(CycledListNodes nodes) {
        Assertions.assertEquals(nodes.cycleStart() != null,
                LinkedListUtil.hasCycle(nodes.head()));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void detectCycleTest(CycledListNodes nodes) {
        Assertions.assertEquals(nodes.cycleStart(), LinkedListUtil.detectCycle(nodes.head()));
    }
}
