package com.sword.offer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * <p>
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) return result;

        int low = 0;
        int high = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (low <= high && left <= right) {

            //向右
            for (int i = left; i <= right; i++)
                result.add(matrix[low][i]);

            //向下
            for (int i = low + 1; i <= high; i++)
                result.add(matrix[i][right]);

            //向左 有可能出现特殊的情况只有一行，为了避免重复访问
            if (low < high) {
                for (int i = right - 1; i >= left; i--)
                    result.add(matrix[high][i]);
            }

            //向上 有可能出现特殊的情况只有一列，为了避免重复访问
            if (left < right) {
                for (int i = high - 1; i >= low + 1; i--)
                    result.add(matrix[i][left]);
            }

            low++;//向下
            high--;//向上
            left++;//向左
            right--;//向右
        }
        return result;
    }
}
