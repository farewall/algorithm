package com.xusn.third;

/**
 * ×Ö·û´®Ïà³Ë
 */
public class Multiply {
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        for (int i = m-1; i >=0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n-1; j>=0; j--) {
                int y = num2.charAt(j) - '0';
                res[i+j+1] = res[i+j+1] + x*y;
            }
        }
        for (int k = m + n -1; k >=1; k--) {
            res[k-1] = res[k-1] + res[k]/10;
            res[k] = res[k] % 10;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start <= m + n -1 && res[start] == 0) {
            start++;
        }
        while (start <= m+n-1) {
            sb.append(res[start]);
            start++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }
}
