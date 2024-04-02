package com.codetop.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = left; i <= right; i++) mat[top][i] = num++; // left to right.
            top++;
            for (int i = top; i <= bottom; i++) mat[i][right] = num++; // top to bottom.
            right--;
            for (int i = right; i >= left; i--) mat[bottom][i] = num++; // right to left.
            bottom--;
            for (int i = bottom; i >= top; i--) mat[i][left] = num++; // bottom to top.
            left++;
        }
        return mat;
    }
}
