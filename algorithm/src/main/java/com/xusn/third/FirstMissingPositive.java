package com.xusn.third;

/**
 * ��һ��ȱʧ������
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        // ԭ�ع�ϣ����nums[i]�ŵ�nums[nums[i]-1]��
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return n+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
