package com.xusn.fourth;

/**
 * ���������
 *
 * ��һ���� '0' �� '1' ��ɵĶ�ά�����ڣ��ҵ�ֻ���� '1' ����������Σ��������������
 */
public class MaxSquare {
    public static int maxSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;
                    }
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {{'0', '1'}, {'1', '0'}};
        System.out.println(maxSquare(matrix));
    }
}
