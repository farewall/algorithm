package com.xusn.second;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�� m �� n �еľ��� matrix ���밴�� ˳ʱ������˳�� �����ؾ����е�����Ԫ�ء�
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
            //������
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            top++;

            //���ϵ���
            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            right--;

            //���ҵ���
            if (top <= bottom) {
                for (int col = right; col >=left; col--) {
                    res.add(matrix[bottom][col]);
                }
                bottom--;
            }

            //���µ���
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
