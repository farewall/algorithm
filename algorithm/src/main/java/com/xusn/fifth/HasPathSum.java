package com.xusn.fifth;

/**
 * ·���ܺ�
 *
 * ����������ĸ��ڵ� root ��һ����ʾĿ��͵����� targetSum ���жϸ������Ƿ���� ���ڵ㵽Ҷ�ӽڵ� ��·��������·�������нڵ�ֵ��ӵ���Ŀ��� targetSum ��������ڣ����� true �����򣬷��� false ��
 *
 * Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣
 */
public class HasPathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (root.left == null && root.right == null) {
            return targetSum==val;
        }
        return hasPathSum(root.left, targetSum-val) || hasPathSum(root.right, targetSum-val);
    }
}
