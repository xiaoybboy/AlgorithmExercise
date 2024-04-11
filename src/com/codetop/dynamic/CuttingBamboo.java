package com.codetop.dynamic;

import java.util.Arrays;

/**
 * 现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。
 */
public class CuttingBamboo {

    /**
     * dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
     */
    public int cuttingBamboo(int bamboo_len) {
        //dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
        int[] dp = new int[bamboo_len + 1];
        Arrays.fill(dp, 0);
        dp[2] = 1;
        for (int i = 3; i < bamboo_len + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[bamboo_len];
    }
}
