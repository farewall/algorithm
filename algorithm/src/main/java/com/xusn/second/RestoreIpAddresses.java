package com.xusn.second;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 *
 * ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 * ����һ��ֻ�������ֵ��ַ��� s �����Ա�ʾһ�� IP ��ַ���������п��ܵ���Ч IP ��ַ����Щ��ַ����ͨ���� s �в��� '.' ���γɡ��� ���� ���������ɾ�� s �е��κ����֡�����԰� �κ� ˳�򷵻ش𰸡�
 */
public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        // curr��źϷ����ֶ���Ϣ
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
