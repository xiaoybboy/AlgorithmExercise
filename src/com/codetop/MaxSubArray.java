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
     * <p>
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int length = nums.length;
        int sum = 0;

        for (int i = 0; i < length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
