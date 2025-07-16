package com.xusn.second;

/**
 *
 * �����������·����
 *
 * �������е� ·�� ������Ϊһ���ڵ����У�������ÿ�����ڽڵ�֮�䶼����һ���ߡ�ͬһ���ڵ���һ��·�������� �������һ�� ����·�� ���ٰ���һ�� �ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ·���� ��·���и��ڵ�ֵ���ܺ͡�
 *
 * ����һ���������ĸ��ڵ� root �������� ���·���� ��
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
