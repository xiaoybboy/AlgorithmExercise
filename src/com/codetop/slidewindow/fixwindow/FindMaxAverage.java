package com.codetop.slidewindow.fixwindow;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0d;
        }
        int start = 0, end = k - 1;
        int curSum = 0;
        for (int i = 0; i <= end; i++) {
            curSum += nums[i];
        }
        int maxSum = curSum;
        while (end < nums.length - 1) {
            curSum -= nums[start];
            start++;
            end++;
            curSum += nums[end];
            maxSum = Math.max(maxSum, curSum);
        }
        return 1.0 * maxSum / k;
    }
}
