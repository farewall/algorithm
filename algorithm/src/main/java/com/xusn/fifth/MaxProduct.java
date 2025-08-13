package com.xusn.fifth;

/**
 *
 * �˻��������
 *
 * ����һ���������� nums �������ҳ������г˻����ķǿ����� �����飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���
 *
 * ���������Ĵ���һ�� 32-λ ������
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // dp[i][0]��ʾ��i��β�����˻���dp[i][1]��ʾ��i��β����С�˻�
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
