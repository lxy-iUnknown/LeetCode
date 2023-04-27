package com.lxy.leetcode.tree;

public class SortedArrayToBST {
    private static TreeNode sortedArrayToBST(int[] numbers, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(numbers[mid]);
            node.left = sortedArrayToBST(numbers, start, mid - 1);
            node.right = sortedArrayToBST(numbers, mid + 1, end);
            return node;
        }
    }

    public static TreeNode sortedArrayToBST(int[] numbers) {
        return sortedArrayToBST(numbers, 0, numbers.length - 1);
    }
}
