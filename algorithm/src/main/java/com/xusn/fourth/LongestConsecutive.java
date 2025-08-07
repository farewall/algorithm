package com.xusn.fourth;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int curr = 1;
                int currNumber = num;
                while (set.contains(currNumber + 1)) {
                    curr++;
                    currNumber++;
                }
                res = Math.max(curr, res);
            }
        }
        return res;
    }
}
