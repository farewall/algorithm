package com.xusn.second;

import java.util.HashMap;
import java.util.Map;

/**
 * ×Ö·û´®Ïà¼Ó£¬ num1 = "11", num2 = "123", output="134"
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int total = a + b + carry;

            int current = total % 10;
            sb.append(current);
            carry = total / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "789"));
    }
}
