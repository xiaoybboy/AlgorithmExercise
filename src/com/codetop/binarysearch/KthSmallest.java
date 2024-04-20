package com.codetop.binarysearch;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 */
public class KthSmallest {

    /**
     * 在二维矩阵中寻找小于等于 mid 的元素个数 count
     * 若这个 count 小于 k，表明第 k 小的数在右半部分且不包含 mid，即 left=mid+1, right=right，又保证了第 k 小的数在 left-right 之间
     * 若这个 count 大于 k，表明第 k 小的数在左半部分且可能包含 mid，即 left=left, right=mid，又保证了第 k 小的数在 left-right 之间
     * 因为每次循环中都保证了第 k 小的数在 left ~ right 之间，当 left==right 时，第 k 小的数即被找出，等于 right
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, n);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    //比mid小的元素的个数
    private int findNotBiggerThanMid(int[][] matrix, int mid, int n) {
        int i = n - 1, j = 0;
        int count = 0;
        //从左下角开始搜索
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                //找到了<=mid的行
                // 第j列有i+1个元素<=mid，因为<i的行的数据一定小于mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }
}
