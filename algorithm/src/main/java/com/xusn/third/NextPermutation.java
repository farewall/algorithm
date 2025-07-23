package com.xusn.third;

/**
 * ��һ������
 *
 * ��������� ��һ������ ��ָ����������һ���ֵ����������С�����ʽ�أ����������������и������ֵ�˳���С����������һ�������У���ô����� ��һ������ �������������������������������Ǹ����С������������һ����������У���ô��������������Ϊ�ֵ�����С�����У�������Ԫ�ذ��������У���
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        // ��Ϊ������1.�ҵ����һ��������i 2. �ҵ����һ������������λ��j������i��j 3.��i+1�������
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        // ------
        int j = n - 1;
        if (i >= 0) {
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,1};
        nextPermutation(nums);
    }
}
