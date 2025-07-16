package com.xusn.second;

/**
 *
 * 二叉树的最大路径和
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {
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

        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxSum;
        }

        public int dfs (TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = Math.max(dfs(node.left), 0);
            int right = Math.max(dfs(node.right), 0);

            int curr = node.val + left + right;
            maxSum = Math.max(maxSum, curr);

            return Math.max(left, right) + node.val;
        }
    }
}
