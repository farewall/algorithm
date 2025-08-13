package com.xusn.fifth;

/**
 *
 * 乘积最大数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个 32-位 整数。
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // dp[i][0]表示以i结尾的最大乘积，dp[i][1]表示以i结尾的最小乘积
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
            dp[i][1] = Math.min(nums[i], Math.min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i]));
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
