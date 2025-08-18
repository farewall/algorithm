package com.xusn.fifth;

import java.util.Stack;

/**
 *
 * ����������II
 * ����һ���ַ������ʽ s ������ʵ��һ�����������������㲢��������ֵ��
 *
 * ���������������������֡�
 *
 * ����Լ�������ı��ʽ������Ч�ġ������м������� [-231, 231 - 1] �ķ�Χ�ڡ�
 *
 * ע�⣺������ʹ���κν��ַ�����Ϊ��ѧ���ʽ��������ú��������� eval() ��
 */
public class Calculate {

    public static int calculate(String s) {
        // ʹ��ջ���洢������Ҫ��ӵ���
        int num = 0;
        // ��һ�������
        char sign = '+';
        String str = s.replaceAll(" ", "");
        int n = str.length();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            char curr = str.charAt(i);
            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            }
            // ���������������һ�εķ��ţ������ҲҪ����
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
