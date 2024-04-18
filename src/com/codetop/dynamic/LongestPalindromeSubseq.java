package com.codetop.dynamic;

public class LongestPalindromeSubseq {
    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * <p>
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * <p>
     * 状态
     * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     * <p>
     * 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * f[i][j] = f[i + 1][j - 1] + 2
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * f[i][j] = max(f[i + 1][j], f[i][j - 1])
     * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     * 初始化
     * f[i][i] = 1 单个字符的最长回文序列是 1
     * 结果
     * f[0][n - 1]
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
