package com.lxy.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaxDepthTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new TreeNode(3), 1),
                Arguments.of(new TreeNode(3, 9), 2),
                Arguments.of(new TreeNode(3, 9, 20, null, null, 15, 7), 3),
                Arguments.of(new TreeNode(3, 9, 20, 4, null, 15, 7, null, null, 5, 6, null, 8), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void maxDepthTest(TreeNode root, int expected) {
        Assertions.assertEquals(expected, MaxDepth.maxDepth(root));
    }
}
