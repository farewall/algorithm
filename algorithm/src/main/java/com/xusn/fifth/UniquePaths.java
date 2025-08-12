package com.xusn.fifth;

/**
 * ��ͬ·��
 *
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 *
 * ���ܹ��ж�������ͬ��·����
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i][j]��ʾ��dp[0][0]����λ�õ�·���� dp[i][j] = dp[i-1]dp[j] + dp[i][j-1]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
