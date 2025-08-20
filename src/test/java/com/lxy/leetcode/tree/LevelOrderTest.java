package com.lxy.leetcode.tree;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.List;

public class LevelOrderTest {
    public static final Arguments[] ARGUMENTS = new Arguments[]{
            Arguments.of(new TreeNode(3),
                    List.of(List.of(3))),
            Arguments.of(new TreeNode(3, 9),
                    List.of(List.of(3), List.of(9))),
            Arguments.of(new TreeNode(3, 9, 20, null, null, 15, 7),
                    List.of(List.of(3), List.of(9, 20), List.of(15, 7))),
            Arguments.of(new TreeNode(3, 9, 20, 4, null, 15, 7, null, null, 5, 6, null, 8),
                    List.of(List.of(3), List.of(9, 20), List.of(4, 15, 7), List.of(5, 6, 8)))
    };

    @ParameterizedTest
    @FieldSource("ARGUMENTS")
    public void maxDepthTest(TreeNode root, List<List<Integer>> expected) {
        TestUtil.assertDoubleListEquals(expected, LevelOrder.levelOrder(root));
    }
}
