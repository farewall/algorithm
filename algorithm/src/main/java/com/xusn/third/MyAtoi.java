package com.xusn.third;

/**
 * �ַ���ת������
 *
 * ������ʵ��һ�� myAtoi(string s) ������ʹ���ܽ��ַ���ת����һ�� 32 λ�з���������
 *
 * ���� myAtoi(string s) ���㷨���£�
 *
 * �ո񣺶����ַ������������õ�ǰ���ո�" "��
 * ���ţ������һ���ַ������軹δ���ַ�ĩβ��Ϊ '-' ���� '+'��������߶������ڣ���ٶ����Ϊ����
 * ת����ͨ������ǰ��������ȡ��������ֱ�������������ַ��򵽴��ַ����Ľ�β�����û�ж�ȡ���֣�����Ϊ0��
 * ���룺������������� 32 λ�з���������Χ [?231,  231 ? 1] ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ�����Ϊ ?231 ������ 231 ? 1 ������Ӧ�ñ�����Ϊ 231 ? 1 ��
 */
public class MyAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i ++;
        }
        if (i == n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return res * sign;

    }
}
