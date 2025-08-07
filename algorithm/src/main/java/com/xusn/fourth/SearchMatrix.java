package com.xusn.fourth;

/**
 * ������ά����2
 *
 * ��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target ���þ�������������ԣ�
 *
 * ÿ�е�Ԫ�ش������������С�
 * ÿ�е�Ԫ�ش��ϵ����������С�
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row < m && col >=0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
