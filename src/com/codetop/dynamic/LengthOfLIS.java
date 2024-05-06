package com.codetop.dynamic;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 */
public class LengthOfLIS {

    /**
     * 动态规划
     * dp[i] 的值代表 nums 前i个数字的最长子序列长度。i位置元素必须被选取
     * <p>
     * 当 nums[i] > nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），此情况下最长上升子序列长度为 dp[j] + 1dp[j]+1 ；
     * 当 nums[i] <= nums[j] 时：nums[i] 无法接在nums[j] 之后，此情况上升子序列不成立，跳过。
     * 上述所有 1. 情况 下计算出的 dp[j] + 1的最大值，为直到 i 的最长上升子序列长度（即 dp[i] ）。实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)
     * 转移方程： dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //如果满足递增条件
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
