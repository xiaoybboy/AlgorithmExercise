package com.codetop.dynamic;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class MinimumTotal {

    public int minimumTota2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            result = Math.min(result, dp[n - 1][k]);
        }
        return result;
    }


    /**
     * dp[i][j] = min(dp[i-1][j],dp[i-1][j-1])+c[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            //每行的第一个数，只有一种方式可以到达
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            //j<i,第i行的数据个数也是i
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            //每行的最后一个数，也只有一种方式到达
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int result = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            result = Math.min(result, dp[n - 1][k]);
        }
        return result;
    }
}
