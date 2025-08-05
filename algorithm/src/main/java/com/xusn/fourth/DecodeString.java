package com.xusn.fourth;

import java.util.Stack;

/**
 * �ַ�������
 *
 * ����һ������������ַ������������������ַ�����
 *
 * �������Ϊ: k[encoded_string]����ʾ���з������ڲ��� encoded_string �����ظ� k �Ρ�ע�� k ��֤Ϊ��������
 *
 * �������Ϊ�����ַ���������Ч�ģ������ַ�����û�ж���Ŀո�������ķ��������Ƿ��ϸ�ʽҪ��ġ�
 *
 * ���⣬�������Ϊԭʼ���ݲ��������֣����е�����ֻ��ʾ�ظ��Ĵ��� k �����粻������� 3a �� 2[4] �����롣
 */
public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int num = 0;
        String res = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                resStack.push(res);
                num = 0;
                res = "";
            } else if (c == ']') {
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder(resStack.pop());
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = temp.toString();
            } else {
                res = res + c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("bc3[a2[c]]"));
    }
}
