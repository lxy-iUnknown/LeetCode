package com.lxy.leetcode.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Deserialize a tree
     *
     * @param first First value
     * @param rest  Rest values
     * @see TreeNodeCodec
     */
    public TreeNode(int first, Integer... rest) {
        TreeNodeCodec.deserialize(this, first, rest);
    }

    private static void appendNode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
        } else {
            sb.append(node.val);
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("TreeNode{val=").append(val).append(", left=");
        appendNode(left, sb);
        sb.append(", right=");
        appendNode(right, sb);
        return sb.append('}').toString();
    }
}