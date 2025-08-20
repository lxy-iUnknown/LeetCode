package com.lxy.leetcode.tree;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/">对称二叉树</a>
 */
public class IsSymmetric {

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                isSymmetric(left.left, right.right) &&
                isSymmetric(left.right, right.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
}
