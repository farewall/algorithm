package com.xusn.third;

import java.util.HashMap;
import java.util.Map;

/**
 * 由先序遍历结果和中序遍历结果构造二叉树
 */
public class BuildTree {

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

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 构造二叉树
     * @param preorder 二叉树的前序遍历
     * @param inorder 二叉树的中序遍历
     * @return 构造后的二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // [3 9 20 15 7]
        // [9 3 15 20 7]
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n-1, 0, n-1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftTreeSize = rootIndex - inLeft;
        root.left = build(preorder, preLeft+1, preLeft+leftTreeSize, inLeft, rootIndex-1);
        root.right = build(preorder, preLeft +1 + leftTreeSize, preRight, rootIndex+1, inRight);
        return root;
    }
}
