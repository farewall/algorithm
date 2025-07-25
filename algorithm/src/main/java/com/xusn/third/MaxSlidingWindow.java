package com.xusn.third;

import java.util.ArrayDeque;

/**
 * �������ڵ����ֵ
 *
 * ����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ��
 *
 * ���� ���������е����ֵ ��
 *
 *
 */
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // ʹ�õ�����˫����У����Բ�����ͷ�Ͷ�β��
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            // ��ͷ�п��ܳ�����Χ:3,2,1���ཱུ��ĳ���, i = 2 k = 2ʱ����Ҫ�Ƴ�nums[0]
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            if (i >= k -1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}
