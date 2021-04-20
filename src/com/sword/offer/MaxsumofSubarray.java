package com.sword.offer;

/**
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * 题目保证没有全为负数的数据
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * <p>
 * 思路：动态规划
 * <p>
 * 设置 dp[0] = arr[0]
 * if dp[i-1] > 0 dp[i] = dp[i-1] + arr[i]
 * if dp[i-1] <= 0 dp[i] = arr[i]
 */
public class MaxsumofSubarray {

    /**
     * 纯粹动态规划
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarrayDynamic(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        //边界条件
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            //转移公式
            dp[i] = Math.max(dp[i - 1], 0) + arr[i];
            //记录最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * max sum of the subarray
     * <p>
     * 优化版本,只需要一个值，记录dp[i-1]即可
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = sum;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum, 0) + arr[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
