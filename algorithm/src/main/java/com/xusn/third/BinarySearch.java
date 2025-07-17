package com.xusn.third;

/**
 * ���ֲ���
 *
 * ����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��дһ���������� nums �е� target����� target ���ڷ����±꣬���򷵻� -1��
 *
 * ������дһ������ O(log n) ʱ�临�Ӷȵ��㷨��
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return -1;
    }
}
