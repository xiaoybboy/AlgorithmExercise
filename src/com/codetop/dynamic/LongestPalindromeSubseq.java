package com.codetop.dynamic;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubseq {

    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 同上：dp[i][j] = dp[i+1][j-1]
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp[i][j]表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度
        //i是左边的指针，j是右边的指针
        int[][] dp = new int[n][n];
        //为什么要从后往前遍历，因为子问题，是dp[i+1],dp[j-1]
        //从后往前遍历，可以保证dp[i+1],dp[j-1]一定有值
        for (int i = n - 1; i >= 0; i--) {
            //单个字符的最长回文长度为1
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //当s[i] = s[j]时，dp[i][j] = dp[i+1][j-1]+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //否则dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
