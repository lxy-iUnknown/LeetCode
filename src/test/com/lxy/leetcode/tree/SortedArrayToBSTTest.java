package com.lxy.leetcode.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SortedArrayToBSTTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3},
                        new TreeNode(1, null, 3)),
                Arguments.of(
                        new int[]{-10, -3, 0, 5, 9},
                        new TreeNode(0, -10, 5, null, -3, null, 9)),
                Arguments.of(
                        new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
                        new TreeNode(5, 2, 8, 0, 3, 6, 10, null, 1, null, 4, null, 7, 9, 11))
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void sortedArrayToBSTTest(int[] numbers, TreeNode expected) {
        TreeNodeTestUtil.assertEquals(expected, SortedArrayToBST.sortedArrayToBST(numbers));
    }
}
