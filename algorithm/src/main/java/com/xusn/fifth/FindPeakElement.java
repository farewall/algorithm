package com.xusn.fifth;

/**
 * ��ֵԪ����ָ��ֵ�ϸ������������ֵ��Ԫ�ء�
 *
 * ����һ���������� nums���ҵ���ֵԪ�ز�������������������ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�
 *
 * ����Լ��� nums[-1] = nums[n] = -�� ��
 *
 * �����ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨����������⡣
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * ����������Ч�� i ���� nums[i] != nums[i + 1]
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid+1]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
