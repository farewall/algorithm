package com.xusn.fourth;

import java.util.Stack;

/**
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
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
