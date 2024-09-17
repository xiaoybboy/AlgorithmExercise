package com.codetop.dynamic;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串
 */
public class IsInterleave {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "b", s3 = "cbb";
        isInterleave(s1, s2, s3);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        //dp[i][j] 代表 s1 前 i 个字符与 s2 前 j 个字符拼接成 s3 的 i +j 字符
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                //第一行
                if (i == 0 && j > 0) {
                    dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                    continue;
                }
                //第一列
                if (j == 0 && i > 0) {
                    dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                    continue;
                }
                //i>0&&j>0时两种情况
                int p = i + j - 1;//s3的长度
                //如果s1的最后一个字符，等于s3的最后一个字符，只需要判断dp[i-1][j]是否为true
                if (s1.charAt(i - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i - 1][j];
                }
                //如果上面不满足，再判断s2的最后一个字符，等于s3最后一个字符的情况
                if (!dp[i][j] && s2.charAt(j - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
