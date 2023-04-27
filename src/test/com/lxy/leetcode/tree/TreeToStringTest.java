package com.lxy.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TreeToStringTest {
    public static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new TreeNode(1), "1"),
                Arguments.of(new TreeNode(1, 2), "1(2)"),
                Arguments.of(new TreeNode(1, null, 3), "1()(3)"),
                Arguments.of(new TreeNode(1, 2, 3), "1(2)(3)"),
                Arguments.of(new TreeNode(1, 2, 3, 4), "1(2(4))(3)"),
                Arguments.of(new TreeNode(1, 2, 3, null, 4), "1(2()(4))(3)"),
                Arguments.of(new TreeNode(1, 2, null, 3, 4), "1(2(3)(4))")
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    public void treeToStringTest(TreeNode root, String expected) {
        Assertions.assertEquals(expected, TreeToString.tree2str(root));
    }
}
