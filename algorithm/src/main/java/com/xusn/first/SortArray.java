package com.xusn.first;

import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
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
     * 该方法的作用是在left至right的区间内，小于基准的数在基准左边，大于基准的数在基准右边
     * @param nums 待排序数组
     * @param left 左区间
     * @param right 右区间
     * @return 基准的位置
     */
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        // [left, i]维护的是小于pivot的数
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
