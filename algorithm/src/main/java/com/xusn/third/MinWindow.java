package com.xusn.third;

import java.util.HashMap;
import java.util.Map;

/**
 * ��С�����Ӵ�
 *
 * ����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ������ s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
 *
 *
 *
 * ע�⣺
 *
 * ���� t ���ظ��ַ�������Ѱ�ҵ����ַ����и��ַ��������벻���� t �и��ַ�������
 * ��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int n = s.length();
        int valid = 0;
        // ά��һ�����ڣ�ֻ����
        Map<Character, Integer> window = new HashMap<>();
        while (right < n) {
            //������[left, right)
            char c = s.charAt(right);
            right++;

            if (countMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (countMap.get(c).intValue() == window.get(c).intValue()) {
                    valid++;
                }
            }

            while (countMap.size() == valid) {
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                char d = s.charAt(left);
                if (countMap.containsKey(d)) {
                    if (countMap.get(d).intValue() == window.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
