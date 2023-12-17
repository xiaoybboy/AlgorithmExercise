package com.codetop;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class SearchMatrix {

    /**
     * 两次二分查找，第一次查所在的行，第二次查所在的列
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        //跟第一列的元素比较，查target所在的行.找到最后一个不大于target的元素所在行
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (matrix[mid][0] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        // 可以先判断，减少时间复杂度
        if (matrix[l][0] == target) return true;
        if (matrix[l][0] > target) return false;

        //找到所在行之后，再进行一次二分查找，找到所在的列
        int left = 0, right = matrix[l].length - 1;
        while (left < right) {
            int m = (left + right) >> 1;
            if (matrix[l][m] >= target) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return matrix[l][left] == target;
    }
}
