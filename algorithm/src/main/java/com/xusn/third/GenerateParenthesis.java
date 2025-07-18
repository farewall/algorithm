package com.xusn.third;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 *
 * ���� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrace(result, "",0, 0, n);
        return result;
    }

    public void backTrace(List<String> result, String path, int left, int right, int n) {
        // �Ϸ����ŵĺ����������ź������Ÿ���һ��������ǰ׺����������>=��������
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
