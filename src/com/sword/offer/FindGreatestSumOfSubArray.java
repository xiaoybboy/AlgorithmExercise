package com.sword.offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * <p>
 * 思路：状态定义：dp[i]表示以i结尾的连续子数组的最大和。所以最终要求dp[n-1]
 * 状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])
 * 解释：如果当前元素为整数，并且dp[i-1]为负数，那么当然结果就是只选当前元素
 * <p>
 * <p>
 * dp[n]代表以当前元素为截止点的连续子序列的最大和，如果dp[n-1]>0，dp[n]=dp[n]+dp[n-1]，因为当前数字加上一个正数一定会变大；
 * <p>
 * 如果dp[n-1]<0，dp[n]不变，因为当前数字加上一个负数一定会变小。使用一个变量max记录最大的dp值返回即可。
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = max;
        for (int i = 1; i < array.length; i++) {
            int newMax = dp[i - 1] + array[i];
            //如果newMax > array[i] 说明dp[i - 1]是负数
            if (newMax > array[i]) {
                dp[i] = newMax;
            } else {
                dp[i] = array[i];
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
