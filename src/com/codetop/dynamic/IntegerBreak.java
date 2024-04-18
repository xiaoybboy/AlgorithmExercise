package com.codetop.dynamic;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 */
public class IntegerBreak {

    /**
     * dp[i] = math.max(j*(i-j),dp[i-j]*j)
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            //i的 时候最大化乘积
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
