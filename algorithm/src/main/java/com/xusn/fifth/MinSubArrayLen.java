package com.xusn.fifth;

/**
 * ������С��������
 *
 * ����һ������ n ���������������һ�������� target ��
 *
 * �ҳ����������������ܺʹ��ڵ��� target �ĳ�����С�� ������ [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ���������ڷ��������������飬���� 0 ��
 *
 * ������ �������������� �ǿ� Ԫ�����С�
 *
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < n) {
            sum = sum + nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left+1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
