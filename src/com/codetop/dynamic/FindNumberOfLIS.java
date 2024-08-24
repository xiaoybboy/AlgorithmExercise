package com.codetop.dynamic;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;

        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] > dp[j]) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                } else {
                    count[i] = count[j];
                }
            }
            ans += dp[i];
        }
        return ans;
    }
}
