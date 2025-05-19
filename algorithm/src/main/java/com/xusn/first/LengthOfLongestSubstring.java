package com.xusn.first;

import java.util.HashMap;
import java.util.Map;

/**
 *
 3. 无重复字符的最长子串
 中等

 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 提示：

 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成
 */
















public class LengthOfLongestSubstring {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String s) {
        // 用于存储窗口内的字符和出现的个数
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            right++;
            // 定义窗口收缩的条件, 当前的字符在窗口内出现多次
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
