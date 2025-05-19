package com.xusn.first;

import java.util.HashMap;
import java.util.Map;

/**
 *
 3. ���ظ��ַ�����Ӵ�
 �е�

 ����һ���ַ��� s �������ҳ����в������ظ��ַ��� � �Ӵ� �ĳ��ȡ�
 ʾ�� 1:

 ����: s = "abcabcbb"
 ���: 3
 ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 ʾ�� 2:

 ����: s = "bbbbb"
 ���: 1
 ����: ��Ϊ���ظ��ַ�����Ӵ��� "b"�������䳤��Ϊ 1��
 ʾ�� 3:

 ����: s = "pwwkew"
 ���: 3
 ����: ��Ϊ���ظ��ַ�����Ӵ��� "wke"�������䳤��Ϊ 3��
 ��ע�⣬��Ĵ𰸱����� �Ӵ� �ĳ��ȣ�"pwke" ��һ�������У������Ӵ���

 ��ʾ��

 0 <= s.length <= 5 * 104
 s ��Ӣ����ĸ�����֡����źͿո����
 */
















public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        // ���ڴ洢�����ڵ��ַ��ͳ��ֵĸ���
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            right++;
            // ���崰������������, ��ǰ���ַ��ڴ����ڳ��ֶ��
            while (windows.get(c) > 1) {
                char d = s.charAt(left);
                windows.put(d, windows.get(d) - 1);
                left ++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}
