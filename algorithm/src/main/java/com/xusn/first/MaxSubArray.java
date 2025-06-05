package com.xusn.first;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 *
 *
 */
public class MaxSubArray {
    public static int maxSubArray(int nums[]) {
        // dp[i]表示以nums[i]结尾的最大和， dp[i]取值为dp[i-1] + nums[i]和nums[i]的大者
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int result = dp[0];
        for (int val : dp) {
            result = Math.max(result, val);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
