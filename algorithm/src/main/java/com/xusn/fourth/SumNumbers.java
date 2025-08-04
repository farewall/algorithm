package com.xusn.fourth;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 */
public class SumNumbers {
    public static class TreeNode {
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

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        current = current * 10 + node.val;
        // 叶子节点直接返回current
        if (node.left == null && node.right == null) {
            return current;
        }
        return dfs(node.left, current) + dfs(node.right, current);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(3), new TreeNode(7));
        System.out.println(sumNumbers(root));
    }
}
