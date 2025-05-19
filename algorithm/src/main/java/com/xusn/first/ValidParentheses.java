package com.xusn.first;


import java.util.*;

/**
 * 合法的括号
 */
public class ValidParentheses {
    public static boolean isValid(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map  = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : input.toCharArray()) {
            // 代表当前放的是左括号，直接放
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
               // 右括号需要检查栈顶的元素和当前的当前是否成对
                Character peek = stack.peek();
                // 放右括号，当前栈中没有元素
                if (peek == null) {
                    return false;
                } else {
                    // 当前栈中有元素
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
