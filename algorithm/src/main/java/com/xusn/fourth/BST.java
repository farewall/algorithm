package com.xusn.fourth;

/**
 * ��֤����������
 *
 * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
 *
 * ��Ч �����������������£�
 *
 * �ڵ��������ֻ���� �ϸ�С�� ��ǰ�ڵ������
 * �ڵ��������ֻ���� �ϸ���� ��ǰ�ڵ������
 * �������������������������Ҳ�Ƕ�����������
 */
public class BST {
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

    public boolean isBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return checkBST(node.left, min, node.val) && checkBST(node.right, node.val, max);
    }
}
