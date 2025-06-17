package com.xusn.second;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            // 奇数
            return getKth(nums1, 0, nums2, 0, total/2 + 1);
        } else {
            // 偶数
            return (getKth(nums1, 0, nums2, 0, total/2) + getKth(nums1, 0, nums2, 0, total/2 + 1))/2.0;
        }
    }

    public static int getKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int mid1 = i + k/2 - 1 < nums1.length ? nums1[i + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = j + k/2 - 1 < nums2.length ? nums2[j + k/2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return getKth(nums1, i + k/2, nums2, j, k - k/2);
        } else {
            return getKth(nums1, i, nums2, j + k/2, k - k/2);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,3,4,7,8};
        int[] nums2 = new int[] {2,5,6,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
