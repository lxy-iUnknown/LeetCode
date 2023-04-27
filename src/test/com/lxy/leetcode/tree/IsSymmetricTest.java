package com.lxy.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsSymmetricTest {

    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new TreeNode(1), true),
                Arguments.of(new TreeNode(1, 2, 2), true),
                Arguments.of(new TreeNode(1, 2, 2, 3, 4, 4, 3), true),
                Arguments.of(new TreeNode(1, 2, 2, 3, null, null, 3, null, 4, 4, null), true),
                Arguments.of(new TreeNode(1, 2, 2, null, 3, 3, null, 4, null, null, 4), true),
                Arguments.of(new TreeNode(1, 2, 2, 3, 4, 4, 3, 5, null, 7, null, null, 7, null, 5), true),
                Arguments.of(new TreeNode(1, 2), false),
                Arguments.of(new TreeNode(1, null, 3), false),
                Arguments.of(new TreeNode(1, 2, 3), false),
                Arguments.of(new TreeNode(1, 2, 2, null, 5, null, 5), false),
                Arguments.of(new TreeNode(1, 2, 2, 3, 4, 3, 4), false),
                Arguments.of(new TreeNode(1, 2, 2, 3, 4, 4, 3, 5, null, 7, null, 7, null, null, 5), false),
                Arguments.of(new TreeNode(1, 2, 2, 3, null, 4, 3, 5, null, null, 7, null, 5), false),
                Arguments.of(new TreeNode(1, null, 2, 4, 3, null, 7, null, 5), false),
                Arguments.of(new TreeNode(1, 2, 2, null, 3, 4), false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void isSymmetricTest(TreeNode root, boolean expected) {
        Assertions.assertEquals(expected, IsSymmetric.isSymmetric(root));
    }
}
