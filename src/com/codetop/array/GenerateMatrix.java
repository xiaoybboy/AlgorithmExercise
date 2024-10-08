package com.codetop.array;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] ans = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num;
                num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num;
                num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num;
                num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = num;
                num++;
            }
            left++;
        }
        return ans;
    }
}
