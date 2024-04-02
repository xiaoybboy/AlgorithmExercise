package com.codetop.dynamic;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class CoinNum {

    /**
     * dp[n]表示凑够总金额n的硬币组合数
     * 遍历 coins，对于其中的每个元素 coin，进行如下操作：
     * <p>
     * 遍历 i 从 coin 到 amount，将 dp[i−coin] 的值加到 dp[i]
     * 最终得到 dp[amount] 的值即为答案。
     * <p>
     * 上述做法不会重复计算不同的排列。因为外层循环是遍历数组 coins 的值，内层循环是遍历不同的金额之和，
     * 在计算 dp[i] 的值时，可以确保金额之和等于 i 的硬币面额的顺序，由于顺序确定，因此不会重复计算不同的排列。
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];    // dp[i]表示凑成金额i的组合数，初始都为0表示不可凑
        dp[0] = 1;      // 金额0有一种组合方式，由0枚硬币组成
        // 枚举每一种硬币
        for(int c: coins){
            // 枚举每一个金额
            for(int a = c; a <= amount; a++){
                dp[a] += dp[a - c];     // 当使用面额为c的硬币时，a的状态取决于a-c
            }
        }
        return dp[amount];
    }
}
