package com.codetop.slidewindow.variablewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 不包含重复元素的子数组的最大和
 */
public class MaximumUniqueSubarray {

    public static int maximumUniqueSubarray(int[] nums) {
        int result = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        int start = 0, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            //窗口收缩，直到窗口内不包含重复元素
            while (set.contains(nums[end])) {
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
            }
            sum += nums[end];
            result = Math.max(result, sum);
            set.add(nums[end]);
        }
        return result;
    }
}
