package com.xusn.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����������ĸ��ڵ� root ��������ڵ�ֵ�� ����β������ �������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 */
public class ZigzagLevelOrder {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       if (root == null) {
           return result;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       boolean leftToRight = true;
       while (!queue.isEmpty()) {
           int size = queue.size();
           LinkedList<Integer> currLevel = new LinkedList<>();

           for (int i = 0; i < size; i++) {
               TreeNode poll = queue.poll();
               if (leftToRight) {
                   currLevel.addLast(poll.val);
               } else {
                   currLevel.addFirst(poll.val);
               }
               if (poll.left != null) {
                   queue.add(poll.left);
               }
               if (poll.right != null) {
                   queue.add(poll.right);
               }
           }
           result.add(currLevel);
           leftToRight = !leftToRight;
       }
       return result;
    }
}
