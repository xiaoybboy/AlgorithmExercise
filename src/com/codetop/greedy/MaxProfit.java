package com.codetop.greedy;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class MaxProfit {

    /**
     * 如果我们真的在买卖股票，我们肯定会想：如果我是在历史最低点买的股票就好了！太好了，在题目中，我们只要用一个变量记录一个历史最低价格 minPrice，
     * 我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minPrice。
     * 因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //i<=maxPosition，说明i的位置可以到达
            if (i <= maxPosition) {
                maxPosition = Math.max(maxPosition, nums[i] + i);
                if (maxPosition > n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
