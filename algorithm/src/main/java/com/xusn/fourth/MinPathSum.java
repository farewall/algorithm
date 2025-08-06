package com.xusn.fourth;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {

    public int dp(int[][] grid) {
        // 动态规划解法
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum(int[][] grid) {
        AtomicInteger minPathSum = new AtomicInteger(Integer.MAX_VALUE);
        dfs(grid, 0, 0, minPathSum, grid[0][0]);
        return minPathSum.get();
    }

    public void dfs(int[][] grid, int m, int n, AtomicInteger minPathSum, int currentSum) {
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            minPathSum.set(Math.min(minPathSum.get(), currentSum));
            return;
        }
        if (m < grid.length - 1) {
            // 下移一步
            dfs(grid, m+1, n, minPathSum, currentSum + grid[m + 1][n]);
        }

        if (n < grid[0].length - 1) {
            dfs(grid, m, n+1, minPathSum, currentSum + grid[m][n+1]);
        }

    }

    public static void main(String[] args) {

    }
}
