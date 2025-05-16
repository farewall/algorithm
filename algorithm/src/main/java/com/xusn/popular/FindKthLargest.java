package com.xusn.popular;

import java.util.Arrays;

/**
 * 找到数组中第K大的元素，排序时不用去重，时间复杂度要求是O(n)
 *
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int partition = partition(nums, left, right);
        if (partition == k) {
            return nums[partition];
        } else if (partition < k) {
            return quickSelect(nums, partition + 1, right, k);
        } else {
            return quickSelect(nums, left, partition - 1, k);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums,  i + 1, right);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }
}
