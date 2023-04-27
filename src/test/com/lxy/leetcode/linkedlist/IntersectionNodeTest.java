package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.ListNodes;
import com.lxy.leetcode.util.NonEmptyIntArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class IntersectionNodeTest {
    private record LinkedLists(ListNode head1, ListNode head2, ListNode intersection) {
    }

    private static LinkedLists createLinkedLists(
            NonEmptyIntArray array1, NonEmptyIntArray array2,
            NonEmptyIntArray rest) {
        ListNodes nodes1 = new ListNodes(array1);
        ListNodes nodes2 = new ListNodes(array2);
        ListNode intersection;
        if (rest == null) {
            intersection = null;
        } else {
            intersection = new ListNode(rest);
            nodes1.end().next = intersection;
            nodes2.end().next = intersection;
        }
        return new LinkedLists(nodes1.head(), nodes2.head(), intersection);
    }

    public static List<LinkedLists> arguments() {
        return List.of(
                createLinkedLists(new NonEmptyIntArray(4, 1),
                        new NonEmptyIntArray(5, 6, 1, 7, 3),
                        new NonEmptyIntArray(8, 4, 5)),
                createLinkedLists(new NonEmptyIntArray(4, 1, 8, 0, 2),
                        new NonEmptyIntArray(5, 6, 1, 7, 3),
                        new NonEmptyIntArray(8, 4, 5)),
                createLinkedLists(new NonEmptyIntArray(1, 9, 1),
                        new NonEmptyIntArray(3),
                        new NonEmptyIntArray(2, 4)),
                createLinkedLists(new NonEmptyIntArray(2, 6, 4),
                        new NonEmptyIntArray(1, 3, 4, 5, 6, 7, 8),
                        null),
                createLinkedLists(new NonEmptyIntArray(1, 2, 3, 4),
                        new NonEmptyIntArray(5, 6, 7, 8),
                        null)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void intersectionNodeTest(LinkedLists linkedLists) {
        LinkedListTestUtil.assertEquals(linkedLists.intersection,
                IntersectionNode.getIntersectionNode(linkedLists.head1, linkedLists.head2));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void intersectionNodeSimpleTest(LinkedLists linkedLists) {
        LinkedListTestUtil.assertEquals(linkedLists.intersection,
                IntersectionNode.getIntersectionNodeSimple(linkedLists.head1, linkedLists.head2));
    }
}
