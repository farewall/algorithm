package com.xusn.first;

/**
 * ��������
 * ����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 *
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 *
 * ���⣬����Լ��������������߾���ˮ��Χ��
 */
public class NumIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i, j + 1);// ����̽��
        dfs(grid, i, j - 1);// ����̽��
        dfs(grid, i + 1, j);//����̽��
        dfs(grid, i - 1, j);//����̽��
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
}
