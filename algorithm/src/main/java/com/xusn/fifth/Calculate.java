package com.xusn.fifth;

import java.util.Stack;

/**
 *
 * 基本计算器II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 *
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */
public class Calculate {

    public static int calculate(String s) {
        // 使用栈来存储最终需要相加的项
        int num = 0;
        // 上一个运算符
        char sign = '+';
        String str = s.replaceAll(" ", "");
        int n = str.length();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            char curr = str.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }
            // 遇到符号则计算上一次的符号，到最后也要计算
            if (!Character.isDigit(curr) || i == n-1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = curr;
                num = 0;
            }
        }
        int res = 0;
        for (Integer item : stack) {
            res = res + item;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3/2"));
    }
}
