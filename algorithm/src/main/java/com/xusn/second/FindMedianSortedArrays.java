package com.xusn.second;

/**
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 *
 * �㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(log (m+n)) ��
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            // ����
            return getKth(nums1, 0, nums2, 0, total/2 + 1);
        } else {
            // ż��
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
