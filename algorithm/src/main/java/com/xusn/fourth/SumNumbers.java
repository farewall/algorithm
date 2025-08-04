package com.xusn.fourth;

/**
 * ����һ���������ĸ��ڵ� root ������ÿ���ڵ㶼�����һ�� 0 �� 9 ֮������֡�
 * ÿ���Ӹ��ڵ㵽Ҷ�ڵ��·��������һ�����֣�
 *
 * ���磬�Ӹ��ڵ㵽Ҷ�ڵ��·�� 1 -> 2 -> 3 ��ʾ���� 123 ��
 * ����Ӹ��ڵ㵽Ҷ�ڵ����ɵ� ��������֮�� ��
 *
 * Ҷ�ڵ� ��ָû���ӽڵ�Ľڵ㡣
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
        // Ҷ�ӽڵ�ֱ�ӷ���current
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
