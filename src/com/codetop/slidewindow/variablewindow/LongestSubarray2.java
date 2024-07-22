package com.codetop.slidewindow.variablewindow;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class LongestSubarray2 {

    public int longestSubarray(int[] nums, int limit) {
        int start = 0, maxLength = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            //比较最大值和最小值
            while (map.lastKey() - map.firstKey() > limit) {
                int count = map.getOrDefault(nums[start], 0) - 1;
                if (count == 0) {
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], count);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
