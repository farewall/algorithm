package com.xusn.third;

/**
 * ·´×ªµ¥´Ê
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i>=0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            while (j >=0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(s, j+1, i+1).append(" ");
            i = j;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String input = "  ttt ca we    dadasd   ";
        String output = reverseWords(input);
        System.out.println(String.format("output is '%s'", output));
    }
}
