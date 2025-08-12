package com.xusn.fifth;

import javafx.util.Pair;

import java.util.LinkedList;

public class WidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Long>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1L));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            long firstIndex = queue.peek().getValue();
            long lastIndex = firstIndex;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> poll = queue.poll();
                TreeNode node = poll.getKey();
                lastIndex = poll.getValue();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * lastIndex));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * lastIndex + 1));
                }
                maxWidth = Math.max(maxWidth, (int)(lastIndex - firstIndex + 1));
            }
        }
        return maxWidth;
    }
}
