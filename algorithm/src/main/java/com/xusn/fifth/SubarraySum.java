package com.xusn.fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 */
public class SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        // 计算两个前缀和相减=k的次数
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
