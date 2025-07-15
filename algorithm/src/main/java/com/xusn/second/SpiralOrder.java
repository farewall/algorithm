package com.xusn.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;
        while (left <= right && top <= bottom) {
            //从左到右
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            //从上到下
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            //从右到左
            if (top <= bottom) {
                for (int col = right; col >=left; col--) {
                    res.add(matrix[bottom][col]);
                }
                bottom--;
            }

            //从下到上
            if (left <= right) {
                for (int row = bottom; row >=top; row--) {
                    res.add(matrix[row][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> res = spiralOrder(matrix);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
