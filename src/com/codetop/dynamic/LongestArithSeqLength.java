package com.codetop.dynamic;

/**
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，
 * 且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 */
public class LongestArithSeqLength {

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length, ans = 0;
        int[][] dp = new int[n][1010];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 表示nums[i]与nums[j]以差为d构成等差数列
                int d = nums[i] - nums[j] + 500;
                // dp[i][d]表示：nums[i]以差为d能与前面的数构成的等差数列的长度
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                ans = Math.max(ans, dp[i][d]);
            }
        }
        return ans + 1;
    }

    //2,3,1,1,4
    public int jump(int[] nums) {
        int end = 0;
        int step = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
