package com.xusn.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        transverse(root, res);
        return res;
    }

    public void transverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        transverse(root.left, res);
        res.add(root.val);
        transverse(root.right, res);
    }
}
