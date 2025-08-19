package com.xusn.fifth;

/**
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 子数组 是数组中连续的 非空 元素序列。
 *
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < n) {
            sum = sum + nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left+1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
