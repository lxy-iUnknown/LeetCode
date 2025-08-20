package com.lxy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">二叉树的层序遍历</a>
 */
public class LevelOrder {
    private static final List<List<Integer>> EMPTY = List.of();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var length = queue.size();
            var list = new ArrayList<Integer>(length);
            for (var i = 0; i < length; i++) {
                var node = queue.poll();
                assert node != null;
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
