package com.xusn.second;

/**
 * 接雨水
 */
public class Trap {
    public int trap(int[] height) {
        // 问题分解为计算每个柱子能接到的雨水数
        int size = height.length;
        //使用dp计算每个位置的前缀最大值
        int[] pre = new int[size];
        pre[0] = height[0];
        for (int i =1; i < size; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }

        //使用dp计算每个位置的后缀最大值
        int[] post = new int[size];
        post[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            post[i] = Math.max(post[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < size; i++) {
            res = res + Math.min(post[i], pre[i]) - height[i];
        }
        return res;
    }
}
