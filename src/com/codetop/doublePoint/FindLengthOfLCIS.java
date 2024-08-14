package com.codetop.doublePoint;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int l = 0; // 起点
        int r = 0; // 终点
        int maxLen = 0; // 待返回的最长长度

        while (r < nums.length)
            if (r == l || nums[r - 1] < nums[r]) { // 保持递增
                maxLen = Math.max(maxLen, r - l + 1); // 比较取大
                r++; // 终点前进
            } else // 递增中断
                l = r; // 更新起点

        return maxLen;
    }
}
