package com.codetop.dynamic;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
