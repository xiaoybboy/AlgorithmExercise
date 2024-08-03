package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0, result = 0;
        int curSum = 0;

        for (int end = 0; end < nums.length; end++) {
            curSum += nums[end];
            while (curSum > goal) {
                curSum -= nums[start];
                start++;
            }
            if (curSum == goal) {
                result++;
            }
        }
        return result;
    }
}
