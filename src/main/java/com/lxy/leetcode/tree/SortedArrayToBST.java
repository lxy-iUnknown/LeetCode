package com.lxy.leetcode.tree;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">将有序数组转换为二叉搜索树</a>
 */
public class SortedArrayToBST {
    private static TreeNode sortedArrayToBST(int[] numbers, int start, int end) {
        if (start > end) {
            return null;
        } else {
            var mid = (start + end) / 2;
            var node = new TreeNode(numbers[mid]);
            node.left = sortedArrayToBST(numbers, start, mid - 1);
            node.right = sortedArrayToBST(numbers, mid + 1, end);
            return node;
        }
    }

    public static TreeNode sortedArrayToBST(int[] numbers) {
        return sortedArrayToBST(numbers, 0, numbers.length - 1);
    }
}
