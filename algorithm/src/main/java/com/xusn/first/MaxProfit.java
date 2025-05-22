package com.xusn.first;

/**
 * ������Ʊ�����ʱ����ֻ������һ��
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int days = prices.length;

        int[][] dp = new int[days][2];
        // dp[i][0]�����i����������й�Ʊ���������
        dp[0][0] = 0;
        // dp[i][1]�����i��������й�Ʊ���������
        dp[0][1] = -prices[0];


       for (int i = 1; i < days; i++) {
           // ���첻���й�Ʊ��������������첻���й�Ʊ��������� �� ������е�������� + �������������ֵ ������
           dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
           // ������й�Ʊ�����������������й�Ʊ��������� �� ���첻���е�������棨0�� + �������������ֵ ������
           dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
       }
       return dp[days - 1][0];
    }
}
