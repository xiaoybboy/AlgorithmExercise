package com.codetop.dfs;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, area(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int area(int[][] grid, int row, int col) {
        //越界
        if (!isValid(grid, row, col)) {
            return 0;
        }
        //不为1
        if (grid[row][col] != 1) {
            return 0;
        }
        //标记为已经遍历
        grid[row][col] = 2;
        return 1 + area(grid, row, col - 1) + area(grid, row - 1, col) + area(grid, row, col + 1) + area(grid, row + 1, col);
    }

    private boolean isValid(int[][] grid, int row, int colum) {
        return row >= 0 && row < grid.length && colum >= 0 && colum < grid[0].length;
    }
}
