package com.codetop.dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int row, int colum) {
        //越过边界
        if (!isValid(grid, row, colum)) {
            return;
        }
        //搜索到0
        if (grid[row][colum] == '0') {
            return;
        }
        grid[row][colum] = '0';
        dfs(grid, row - 1, colum);
        dfs(grid, row, colum - 1);
        dfs(grid, row, colum + 1);
        dfs(grid, row + 1, colum);
    }

    private boolean isValid(char[][] grid, int row, int colum) {
        return row >= 0 && row < grid.length && colum >= 0 && colum < grid[0].length;
    }
}
