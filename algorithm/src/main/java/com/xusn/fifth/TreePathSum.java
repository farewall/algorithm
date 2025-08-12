package com.xusn.fifth;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * ·���ܺ�
 * ����������ĸ��ڵ� root ��һ������Ŀ��� targetSum ���ҳ����� �Ӹ��ڵ㵽Ҷ�ӽڵ� ·���ܺ͵��ڸ���Ŀ��͵�·����
 *
 * Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣
 */
public class TreePathSum {

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, res, path, targetSum);
        return res;
    }

    public void dfs(TreeNode node, List<List<Integer>> res, List<Integer> path, int targetSum) {
          if (node == null) {
              return;
          }
          path.add(node.val);
          if (node.left == null && node.right == null && node.val == targetSum) {
              res.add(new ArrayList<>(path));
          } else {
              dfs(node.left, res, path, targetSum-node.val);
              dfs(node.right, res, path, targetSum-node.val);
          }
          path.remove(path.size() -1);
    }
}
