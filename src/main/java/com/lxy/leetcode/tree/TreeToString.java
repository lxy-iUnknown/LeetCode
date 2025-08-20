package com.lxy.leetcode.tree;

/**
 * <a href="https://leetcode.cn/problems/construct-string-from-binary-tree/">根据二叉树创建字符串</a>
 */
public class TreeToString {

    private static void appendNode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(');
            appendNode(root.left, sb);
            sb.append(')');
            if (root.right != null) {
                sb.append('(');
                appendNode(root.right, sb);
                sb.append(')');
            }
        }
    }

    public static String tree2str(TreeNode root) {
        var sb = new StringBuilder();
        appendNode(root, sb);
        return sb.toString();
    }
}
