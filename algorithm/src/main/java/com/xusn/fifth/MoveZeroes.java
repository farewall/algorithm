package com.xusn.fifth;

/**
 * �ƶ�0
 *
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 *
 * ��ע�� �������ڲ���������������ԭ�ض�������в�����
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < n) {
            nums[slow] = 0;
            slow++;
        }
    }
}
