package com.codetop.dynamic;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//以i为结尾的最长子序列的长度
        int[] count = new int[n];//到i结尾最长子序列的数量
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int curIMaxLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //长度边长了，数量等于count[j]
                    if (dp[j] + 1 > curIMaxLen) {
                        curIMaxLen = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == curIMaxLen) {
                        //如果长度没变，那么数量+count[j]
                        count[i] += count[j];
                    }
                }
            }
            dp[i] = curIMaxLen;
            maxLen = Math.max(maxLen, curIMaxLen);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}
