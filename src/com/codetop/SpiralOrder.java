package com.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left <= right && top <= bottom) {
            //1 从(top, left) -> (top, right)
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);
            //2 从(top + 1, right) -> (bottom, right)
            for (int i = top + 1; i <= bottom; i++)
                ans.add(matrix[i][right]);
            if (top < bottom && left < right) {
                //3 从(bottom, right - 1) -> (bottom, left + 1)
                for (int i = right - 1; i > left; i--)
                    ans.add(matrix[bottom][i]);
                //4 从(bottom, left) -> (top - 1, left)
                for (int i = bottom; i > top; i--)
                    ans.add(matrix[i][left]);
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return ans;
    }
}
