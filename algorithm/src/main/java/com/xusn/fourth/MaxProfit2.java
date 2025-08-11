package com.xusn.fourth;

/**
 * 买卖股票的最佳时机II
 *
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        // dp[i][0] 为第i天不持有股票的最大收益
        dp[0][0] = 0;
        // dp[i][1] 为第i天持有股票的最大收益
        dp[0][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            // 分为前天持有和不持有两种情况的最大收益
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[days-1][0];
    }
}
