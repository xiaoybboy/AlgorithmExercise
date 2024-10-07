package com.codetop.base;

/**
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int count = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                //偶数 判断起始位置
                int x = Math.min(i, m - 1);
                int y = i - x;
                //从左下到右上 移动
                while (y < n && x >= 0) {
                    ans[count++] = mat[x][y];
                    x--;
                    y++;
                }
            } else {
                //奇数 判断起始位置
                int y = Math.min(i, n - 1);
                int x = i - y;
                //从右上到左下移动
                while (x < m && y >= 0) {
                    ans[count++] = mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return ans;
    }
}
