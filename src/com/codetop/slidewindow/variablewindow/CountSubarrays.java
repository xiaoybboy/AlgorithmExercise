package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * <p>
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * <p>
 * 子数组是数组中的一个连续元素序列
 */
public class CountSubarrays {

    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int start = 0, cnt = 0;
        int result = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[start] == max) {
                    cnt--;
                }
                start++;
            }
            result += start;
        }
        return result;
    }
}
