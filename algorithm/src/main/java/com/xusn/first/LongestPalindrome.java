package com.xusn.first;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            // aba abba
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String input, int left, int right) {
        // abba aba
        while (left >= 0 && right < input.length()
                && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
