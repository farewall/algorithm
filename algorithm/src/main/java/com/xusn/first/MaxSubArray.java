package com.xusn.first;

/**
 * ����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 *
 * �������������е�һ���������֡�
 *
 *
 */
public class MaxSubArray {
    public static int maxSubArray(int nums[]) {
        // dp[i]��ʾ��nums[i]��β�����ͣ� dp[i]ȡֵΪdp[i-1] + nums[i]��nums[i]�Ĵ���
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
