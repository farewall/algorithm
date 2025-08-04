package com.xusn.third;

import java.util.ArrayList;
import java.util.List;

/**
 * ×Ó¼¯
 */
public class Subsets {
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(nums, 0, path, res);
        return res;
    }

    public static void backTrace(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length;i++) {
            path.add(nums[i]);
            backTrace(nums, i+1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        subset(new int[] {1,2,3});
    }
}
