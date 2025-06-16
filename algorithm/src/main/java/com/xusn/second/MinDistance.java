package com.xusn.second;

/**
 * ������������ word1 �� word2�� �뷵�ؽ� word1 ת���� word2 ��ʹ�õ����ٲ�����  ��
 *
 * ����Զ�һ�����ʽ����������ֲ�����
 *
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]�ĺ����ǽ�world1��ǰi���ַ����world2��ǰj���ַ�����С����
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1;j <= n; j++) {
                //ǰi�����±���i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // ��dp[i-1][j-1]�Ļ������޸�һ�Σ���dp[i][j-1]�Ļ����ϲ���һ�Σ���dp[i-1][j]�Ļ�����ɾ��һ��
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
