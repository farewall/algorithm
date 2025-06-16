package com.xusn.second;

/**
 * ����ˮ
 */
public class Trap {
    public int trap(int[] height) {
        // ����ֽ�Ϊ����ÿ�������ܽӵ�����ˮ��
        int size = height.length;
        //ʹ��dp����ÿ��λ�õ�ǰ׺���ֵ
        int[] pre = new int[size];
        pre[0] = height[0];
        for (int i =1; i < size; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }

        //ʹ��dp����ÿ��λ�õĺ�׺���ֵ
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
