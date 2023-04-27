package com.lxy.leetcode.tree;

import com.lxy.leetcode.util.TestUtil;
import org.junit.jupiter.api.AssertionFailureBuilder;
import org.junit.jupiter.api.Assertions;

public class TreeNodeTestUtil {

    public static void assertEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected == null || actual == null) {
            TestUtil.assertFail(expected, actual, "Sub-tree not equal");
            return;
        }
        Assertions.assertEquals(expected.val, actual.val, "Tree node value not equal");
        assertEquals(expected.left, actual.left);
        assertEquals(expected.right, actual.right);
    }
}
