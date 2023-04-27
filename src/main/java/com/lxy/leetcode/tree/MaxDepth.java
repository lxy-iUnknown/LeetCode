package com.lxy.leetcode.tree;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">树的最大深度</a>
 */
public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
