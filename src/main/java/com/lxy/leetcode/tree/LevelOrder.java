package com.lxy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    private static final List<List<Integer>> EMPTY = List.of();

    @SuppressWarnings("DataFlowIssue")
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
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
