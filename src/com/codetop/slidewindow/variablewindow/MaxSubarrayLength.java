package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * 请你返回 nums 中 最长好 子数组的长度。
 * <p>
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 */
public class MaxSubarrayLength {
    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int start = 0, maxLength = 0;
        for (int end = 0; end < nums.length; end++) {
            int newCount = tempMap.getOrDefault(nums[end], 0) + 1;
            tempMap.put(nums[end], newCount);
            //如果当前元素的频率>k
            while (tempMap.get(nums[end]) > k) {
                int prev = nums[start];
                //在左边窗口收缩的时候，更新tempMap
                tempMap.put(prev, tempMap.get(prev) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
