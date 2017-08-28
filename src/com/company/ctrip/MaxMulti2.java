package com.company.ctrip;

import java.util.Scanner;

/**
 * 01背包问题的变种
 */
public class MaxMulti2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = largestProductOfN(n);
        System.out.println(result);
        in.close();
    }

    private static int largestProductOfN(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int k = 0; k <= n; k++) {
            dp[0][k] = 1;
            dp[k][0] = 1;
        }

        // dp[i][j] 从i 中分出j,能够得到的最大值
        //类似于01背包问题，背包容量为i，一次放入0,1,2,3----j,所能取得的乘积最大值
        // dp[i][j-1] 从0--j-1 中
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //dp[i - j][j - 1] * j 把j放入背包的值（分解出j）
                //dp[i][j - 1] 不把j放入背包的，前面j-1个数依次放入背包（分解）能取得的最大值
                dp[i][j] = Math.max(dp[i - j][j - 1] * j, dp[i][j - 1]);
            }
        }
        return dp[n][n];
    }
}
