package com.xusn.fifth;

/**
 * ����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
 *
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        // Boyer-MooreͶƱ�㷨 O(n) O(1)  HashMap�ռ临�Ӷȸ���
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
