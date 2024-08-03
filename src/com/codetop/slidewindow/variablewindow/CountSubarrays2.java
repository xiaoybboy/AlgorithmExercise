package com.codetop.slidewindow.variablewindow;

/**
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * <p>
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 */
public class CountSubarrays2 {

    public long countSubarrays2(int[] nums, long k) {
        long ans = 0;
        long sum = 0, cnt = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            cnt++;
            while (sum * cnt >= k) {
                sum -= nums[l];
                cnt--;
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
