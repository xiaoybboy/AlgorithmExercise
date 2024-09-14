package com.codetop;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {

    /**
     * dp[i] =  dp[i-1] + nums[i] ;if dp[i-1] > 0
     * dp[i] = nums[i] ;if dp[i-1] < 0
     * sum 局部之和
     * 如果 sum > 0，sum + 当前值一定大于当前值；则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，sum + 当前值一定小于当前值；则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
