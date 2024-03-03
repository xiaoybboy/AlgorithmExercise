package com.codetop.array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindTargetIn2DPlants {

    /**
     * 从数组的右上角开始搜索，两个搜索方向，左或者下；左边小于当前值，下面大于当前值
     * 如果current>target,向左搜索
     * 如果current<target,向下搜索
     *
     * @param matrix 目标矩阵
     * @param target 目标值
     * @return
     */
    public boolean findTargetIn2DPlants(int[][] matrix, int target) {
        // 数组问题记得判空
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            int current = matrix[row][column];
            if (current == target) {
                return true;
            } else if (current > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
