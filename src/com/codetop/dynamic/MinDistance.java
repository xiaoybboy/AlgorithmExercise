package com.codetop.dynamic;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class MinDistance {

    /**
     * dp[i][j] 代表 word1 到 i 位置转换成 word2 到 j 位置需要最少步数
     * <p>
     * 所以，
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     * 注意，针对第一行，第一列要单独考虑
     * 第一行，是 word1 为空变成 word2 最少步数，就是插入操作
     * 第一列，是 word2 为空，需要的最少步数，就是删除操作
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;//表示空串
        //从空串变成word1需要的操作数
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        //从空串变成word2需要的操作数
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果字符相同，则dp[i][j] = dp[i - 1][j - 1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i - 1][j - 1]对应替换操作; dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
