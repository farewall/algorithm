package com.xusn.first;

/**
 * �������� nums ���������У������е�ֵ ������ͬ ��
 *
 * �ڴ��ݸ�����֮ǰ��nums ��Ԥ��δ֪��ĳ���±� k��0 <= k < nums.length���Ͻ����� ��ת��ʹ�����Ϊ [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]���±� �� 0 ��ʼ �����������磬 [0,1,2,4,5,6,7] ���±� 3 ������ת����ܱ�Ϊ [4,5,6,7,0,1,2] ��
 *
 * ���� ��ת�� ������ nums ��һ������ target ����� nums �д������Ŀ��ֵ target ���򷵻������±꣬���򷵻� -1 ��
 *
 * ��������һ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��������⡣
 *
 *
 */
public class SearchRotateSortArray {
    public static int search(int[] nums, int target) {
        // ��ת��������ʵ�����Ƿ�Ϊ���������������
        // ����ʹ�ö��ֲ��ҵ�ǰ��������һ��������������
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // ��ֹ�������
            if (nums[mid] == target) {
                return mid;
            }
            // ��벿������
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // �Ұ벿������
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
