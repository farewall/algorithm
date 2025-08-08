package com.xusn.fourth;

/**
 * ��������ֱ��
 */
public class DiameterOfBinaryTree {
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

     int maxDiameter = 0;

     public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
     }

    /**
     * ������nodeΪ�������߶�
     * @param node
     * @return
     */
     public int dfs(TreeNode node) {
          if (node == null) {
              return 0;
          }
          int left = dfs(node.left);
          int right = dfs(node.right);
          maxDiameter = Math.max(maxDiameter, left + right);
          return Math.max(left, right) + 1;
     }
}
