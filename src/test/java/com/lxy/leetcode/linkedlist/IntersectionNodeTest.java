package com.lxy.leetcode.linkedlist;

import com.lxy.leetcode.util.ListNodes;
import com.lxy.leetcode.util.NonEmptyIntArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

public class IntersectionNodeTest {
    public static final Arguments[] ARGUMENTS = {
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
    };

    private static Arguments createLinkedLists(
            NonEmptyIntArray array1, NonEmptyIntArray array2,
            NonEmptyIntArray rest) {
        var nodes1 = new ListNodes(array1);
        var nodes2 = new ListNodes(array2);
        ListNode intersection;
        if (rest == null) {
            intersection = null;
        } else {
            intersection = new ListNode(rest);
            nodes1.end().next = intersection;
            nodes2.end().next = intersection;
        }
        return Arguments.of(nodes1.head(), nodes2.head(), intersection);
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void intersectionNodeTest(ListNode head1, ListNode head2, ListNode intersection) {
        LinkedListTestUtil.assertEquals(
                intersection,
                IntersectionNode.getIntersectionNode(head1, head2)
        );
    }

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void intersectionNodeSimpleTest(ListNode head1, ListNode head2, ListNode intersection) {
        LinkedListTestUtil.assertEquals(
                intersection,
                IntersectionNode.getIntersectionNodeSimple(head1, head2)
        );
    }
}