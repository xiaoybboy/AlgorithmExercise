package com.codetop.dynamic;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */
public class MaxSubArray {
    //dp[i] = dp[i-1] + nums[i]; dp[i-1]>0
    //dp[i] = nums[i]
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
