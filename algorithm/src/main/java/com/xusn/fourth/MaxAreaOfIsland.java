package com.xusn.fourth;

/**
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    /**
     * 返回以grid[i][j]开始搜索的这片岛屿的面积
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j <0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j]=0;
        int area = 1;
        area = area + dfs(grid, i + 1, j);
        area = area + dfs(grid, i, j+1);
        area = area + dfs(grid, i, j-1);
        area = area + dfs(grid, i-1, j);
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
