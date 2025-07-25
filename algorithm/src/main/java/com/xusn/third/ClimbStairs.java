package com.xusn.third;

/**
 * ��¥��
 *
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 *
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        // 쳲���������
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
