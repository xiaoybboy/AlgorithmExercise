package com.codetop.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (true) {
            //从left ------ right遍历
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if (++top > bottom) break;

            //从top-------- bottom遍历
            for (int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            if (--right < left) break;

            //从right-------- left遍历
            for (int k = right; k >= left; k--) {
                ans.add(matrix[bottom][k]);
            }
            if (--bottom > top) break;

            //从right-------- left遍历
            for (int l = bottom; l > top; l--) {
                ans.add(matrix[l][left]);
            }
            if (++left > right) break;
        }
        return ans;
    }

    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * <p>
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1, target = n * n;
        int[][] res = new int[n][n];
        while (count <= target) {
            //从左到右填充，相当于缩小上边界
            for (int j = left; j <= right; j++) res[top][j] = count++;
            //缩小上边界
            top++;
            //从上向下填充，相当于缩小右边界
            for (int i = top; i <= bottom; i++) res[i][right] = count++;
            //缩小右边界
            right--;
            //从右向左填充，相当于缩小下边界
            for (int j = right; j >= left; j--) res[bottom][j] = count++;
            //缩小下边界
            bottom--;
            //从下向上填充，相当于缩小左边界
            for (int i = bottom; i >= top; i--) res[i][left] = count++;
            //缩小左边界
            left++;
        }
        return res;
    }
}
