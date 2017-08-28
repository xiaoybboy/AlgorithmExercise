package com.company.ctrip;

import java.util.Scanner;

/**
 * 一个一维数组，记录n天中每天的携程股价。 股市交易规则如下：
 * <p>
 * a）一天只能有买进或者卖出一种操作，也可以不做任何操作，卖出时价格减买入时价格即为收益.
 * b）每次卖出操作后有冻结期，k天之后才能进行下一次买进操作（k>=1） c）买进之后必须卖出才能再次买进.
 * 设计一个算法，找到交易收益最大化的买进卖出策略，返回最后的最大收益值
 * <p>
 * 输入 一维正整数数组，表示每天股价 正整数k，表示冷冻期
 * <p>
 * 样例输入 int[] sotckPrice = {1,2,3,5,2,6,3,7}; int k = 2;
 * <p>
 * 输入为
 * <p>
 * 8（表示数组长度）
 * <p>
 * 1（开始依次输入数组元素）2 3 5 2 6 3 7
 * <p>
 * 2（输入k）
 *
 * @author XIAO
 */
public class StockDeal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int stockPrice[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                stockPrice[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            System.out.println(getMaxProfit(n, stockPrice, k));
        }
        scanner.close();
    }

    // 动态规划求解最大收益
    private static int getMaxProfit(int n, int stockPrice[], int k) {
        int cur = -1000000000, res = 0;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(stockPrice[i] + cur, dp[i - 1]);
            if (i >= k) {
                cur = Math.max(cur, dp[i - k] - stockPrice[i]);
            } else {
                cur = Math.max(cur, -stockPrice[i]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
