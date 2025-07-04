package com.xusn.second;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]的含义是将world1的前i个字符变成world2的前j个字符的最小步骤
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1;j <= n; j++) {
                //前i个的下表是i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 在dp[i-1][j-1]的基础上修改一次，在dp[i][j-1]的基础上插入一次，在dp[i-1][j]的基础上删除一次
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
