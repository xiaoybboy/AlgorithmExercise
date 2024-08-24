package com.codetop.slidewindow.variablewindow;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target
 * * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。 长度最小的 连续子数组
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            //窗口滑动-不断收缩左窗口
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
