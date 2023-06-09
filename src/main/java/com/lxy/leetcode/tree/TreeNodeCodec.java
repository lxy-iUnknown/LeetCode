package com.lxy.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Format: <a href="http://support.leetcode.cn/hc/kb/article/1567641/">Tree node serialization format</a><br/>
 * Algorithm: <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/solutions/290289/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/">Serialization and deserialization algorithm</a>
 */
public class TreeNodeCodec {
    private record SerializedNodes(ArrayList<Integer> list, int end) {
    }

    private static final Integer[] EMPTY = new Integer[0];

    private static SerializedNodes serializeInternal(TreeNode root) {
        Objects.requireNonNull(root, "Tree root is null");
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
            } else {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        int end = list.size();
        while (--end >= 0) {
            if (list.get(end) != null) {
                break;
            }
        }
        return new SerializedNodes(list, end);
    }

    private static void createNode(TreeNode node, Queue<TreeNode> queue,
                                   Integer value, boolean leftOrRight) {
        if (value != null) {
            TreeNode child = new TreeNode(value);
            if (leftOrRight) {
                node.left = child;
            } else {
                node.right = child;
            }
            queue.add(child);
        }
    }

    private static void deserialize(TreeNode root, Integer... rest) {
        int length = rest.length;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.add(root);
        for (; ; ) {
            if (queue.isEmpty()) {
                throw new IllegalArgumentException("Invalid tree element at index " + index);
            }
            TreeNode node = queue.poll();
            if (index >= length) {
                break;
            }
            createNode(node, queue, rest[index++], true);
            if (index >= length) {
                break;
            }
            createNode(node, queue, rest[index++], false);
        }
    }

    public static TreeNode deserialize(int first, Integer... rest) {
        TreeNode root = new TreeNode(first);
        deserialize(root, rest);
        return root;
    }

    public static void deserialize(TreeNode root, int first, Integer... rest) {
        root.val = first;
        deserialize(root, rest);
    }

    public static String toString(TreeNode root) {
        var nodes = serializeInternal(root);
        var list = nodes.list();
        var end = nodes.end();
        var sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i <= end; i++) {
            sb.append(list.get(i));
            if (i < end) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }

    public static Integer[] serialize(TreeNode root) {
        var nodes = serializeInternal(root);
        var list = nodes.list();
        list.subList(nodes.end(), list.size()).clear();
        return list.toArray(EMPTY);
    }
}