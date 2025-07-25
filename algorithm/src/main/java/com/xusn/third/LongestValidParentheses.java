package com.xusn.third;

import java.util.Stack;

/**
 * ���Ч����(����)
 *
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    // ��������Գɹ�������
                    stack.push(i);
                } else {
                    int validLength = i - stack.peek();
                    maxLength = Math.max(maxLength, validLength);
                }
            }
        }
        return maxLength;
    }
}
