package com.xusn.fourth;

/**
 * ������Ʊ�����ʱ��II
 *
 * ����һ���������� prices ������ prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�
 *
 * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�� ��� ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�
 *
 * ���� ���ܻ�õ� ��� ���� ��
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        // dp[i][0] Ϊ��i�첻���й�Ʊ���������
        dp[0][0] = 0;
        // dp[i][1] Ϊ��i����й�Ʊ���������
        dp[0][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            // ��Ϊǰ����кͲ���������������������
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[days-1][0];
    }
}
