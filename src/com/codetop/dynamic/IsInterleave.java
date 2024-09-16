package com.codetop.dynamic;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串
 */
public class IsInterleave {
    //1.如果 s1的第 i 个元素和 s3的第 i+j 个元素相等，那么 s1的前i 个元素和 s2的前 j 个元素是否能交错组成 s3的前 i+j 个元素
    // 取决于 s1的前 i−1 个元素和 s2 的前 j 个元素是否能交错组成 s3的前 i+j−1 个元素，即此时 f(i,j)取决于 f(i−1,j)
    // 在此情况下如果 f(i−1,j)为真，则 f(i,j)也为真。
    // 同样的，如果 s2的第 j 个元素和 s3的第 i+j个元素相等并且 f(i,j−1) 为真，则 f(i,j) 也为真
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] 代表 s1 前 i 个字符与 s2 前 j 个字符拼接成 s3 的 i+j 字符
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}
