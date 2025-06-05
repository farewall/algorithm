package com.xusn.first;

import java.util.Random;

/**
 * ����һ���������� nums�����㽫�������������С�
 *
 * ������� ��ʹ���κ����ú��� ������½�����⣬ʱ�临�Ӷ�Ϊ O(nlog(n))�����ҿռ临�ӶȾ�����С��
 */
public class SortArray {
    public static int[] sortArray(int [] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int randomPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt((right - left + 1)) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    /**
     * �÷�������������left��right�������ڣ�С�ڻ�׼�����ڻ�׼��ߣ����ڻ�׼�����ڻ�׼�ұ�
     * @param nums ����������
     * @param left ������
     * @param right ������
     * @return ��׼��λ��
     */
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        // [left, i]ά������С��pivot����
        int i = left - 1;

        while (left < right) {
            if (nums[left] < pivot) {
                i++;
                swap(nums, i, left);
            }
            left++;
        }
        swap(nums, right, i + 1);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {110,100,0};
        sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
