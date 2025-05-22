package com.xusn.first;

/**
 * 买卖股票的最佳时机，只能买卖一次
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int days = prices.length;

        int[][] dp = new int[days][2];
        // dp[i][0]代表第i天结束不持有股票的最大收益
        dp[0][0] = 0;
        // dp[i][1]代表第i天结束持有股票的最大收益
        dp[0][1] = -prices[0];


       for (int i = 1; i < days; i++) {
           // 今天不持有股票的最大收益是昨天不持有股票的最大收益 与 昨天持有的最大收益 + 今天卖出收益的值 更大者
           dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
           // 今天持有股票的最大收益是昨天持有股票的最大收益 与 昨天不持有的最大收益（0） + 今天买入收益的值 更大者
           dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
       }
       return dp[days - 1][0];
    }
}
