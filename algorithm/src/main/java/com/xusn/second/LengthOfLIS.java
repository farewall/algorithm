package com.xusn.second;

import java.util.Arrays;

/**
 * �����������
 * ����һ���������� nums ���ҵ�������ϸ���������еĳ��ȡ�
 *
 * ������ ���������������������У�ɾ������ɾ���������е�Ԫ�ض����ı�����Ԫ�ص�˳�����磬[3,6,2,7] ������ [0,3,1,6,2,2,7] �������С�
 */
public class LengthOfLIS {

    public int dp(int[] nums) {
        // ��̬�滮�ⷨ dp[i]��ʾ��nums[i]��β������������еĳ��� N^2
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
