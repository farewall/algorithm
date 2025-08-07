package com.xusn.fourth;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������
 *
 * ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�
 *
 * ������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
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
