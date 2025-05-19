package com.xusn.first;


import java.util.*;

/**
 * �Ϸ�������
 */
public class ValidParentheses {
    public static boolean isValid(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map  = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : input.toCharArray()) {
            // ����ǰ�ŵ��������ţ�ֱ�ӷ�
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
               // ��������Ҫ���ջ����Ԫ�غ͵�ǰ�ĵ�ǰ�Ƿ�ɶ�
                Character peek = stack.peek();
                // �������ţ���ǰջ��û��Ԫ��
                if (peek == null) {
                    return false;
                } else {
                    // ��ǰջ����Ԫ��
                    if (map.get(peek) != c) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
