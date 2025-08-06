package com.xusn.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class PreOrder {
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

    public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> res = new ArrayList<>();
          dfs(root, res);
          return res;
    }

    public void dfs(TreeNode node, List<Integer> res) {
          if (node == null) {
              return;
          }
          res.add(node.val);
          dfs(node.left, res);
          dfs(node.right, res);
    }
}
