package com.codetop.binarysearch;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非严格递减顺序排列。 请你统计并返回 grid 中 负数 的数目。
 */
public class CountNegatives {

    public static int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int totalCount = 0;
        for (int i = 0; i < m; i++) {
            int start = -1, end = n;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (grid[i][mid] >= 0) {//isBlue
                    start = mid;
                } else {
                    end = mid;
                }
            }
            totalCount += n - start - 1;
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        countNegatives(grid);
    }
}
