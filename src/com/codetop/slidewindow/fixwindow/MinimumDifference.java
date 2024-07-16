package com.codetop.slidewindow.fixwindow;

import java.util.Arrays;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 */
public class MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = k - 1;
        int minDiff = nums[end] - nums[start];
        while (end < nums.length) {
            minDiff = Math.min(minDiff, nums[end] - nums[start]);
            start++;
            end++;
        }
        return minDiff;
    }
}
