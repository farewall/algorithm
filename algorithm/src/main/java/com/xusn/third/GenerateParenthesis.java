package com.xusn.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrace(result, "",0, 0, n);
        return result;
    }

    public void backTrace(List<String> result, String path, int left, int right, int n) {
        // 合法括号的含义是左括号和右括号个数一样，任意前缀的左括号数>=右括号数
        if (path.length() == 2 * n) {
            result.add(path);
            return;
        }
        if (left < n) {
            backTrace(result, path + "(", left + 1, right, n);
        }

        if (right < left) {
            backTrace(result, path + ")", left, right + 1, n);
        }
    }
}
