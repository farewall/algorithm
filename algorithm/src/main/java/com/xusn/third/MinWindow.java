package com.xusn.third;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
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
        // 维护一个窗口，只存相
        Map<Character, Integer> window = new HashMap<>();
        while (right < n) {
            //窗口是[left, right)
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
