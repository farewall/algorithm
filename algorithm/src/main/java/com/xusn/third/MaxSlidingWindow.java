package com.xusn.third;

import java.util.ArrayDeque;

/**
 * 滑动窗口的最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 使用单调的双向队列（可以操作队头和队尾）
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // 队头有可能超出范围:3,2,1这类降序的场景, i = 2 k = 2时，需要移除nums[0]
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i >= k -1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}
