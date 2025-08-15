package com.xusn.fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ΪK��������
 *
 * ����һ���������� nums ��һ������ k ������ͳ�Ʋ����� �������к�Ϊ k ��������ĸ��� ��
 *
 * ��������������Ԫ�ص������ǿ����С�
 *
 */
public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        // ��������ǰ׺�����=k�Ĵ���
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum = sum + num;
            if (sumCount.containsKey(sum-k)) {
                count = count + sumCount.get(sum-k);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
