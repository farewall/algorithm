package com.xusn.fifth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String[] input = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        if (Objects.equals(input[0], "0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,20,3,4,67};
        System.out.println(largestNumber(nums));
    }
}
