package com.xusn.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        // curr存放合法、分段信息
        List<String> current = new ArrayList<>();
        backTrace(res, 0, current, s);
        return res;
    }

    public static void backTrace(List<String> res, int start, List<String> current, String input) {
        if (current.size() == 4 && start == input.length()) {
            res.add(String.join(".", current));
            return;
        }
        if (current.size() == 4 || start == input.length()) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > input.length()) {
                break;
            }
            String segment = input.substring(start, start + i);
            if (isValid(segment)) {
                current.add(segment);
                backTrace(res, start + i, current, input);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >=0 && num <= 255;
    }

    public static void main(String[] args) {
        String input = "25525511135";
        System.out.println(restoreIpAddresses(input));
    }
}
