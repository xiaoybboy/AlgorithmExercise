package com.company.ctrip;

import java.util.Scanner;

/**
 * 有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
 * <p>
 * 输入
 * <p>
 * 一个整数
 * <p>
 * 样例输入
 * <p>
 * 15
 * <p>
 * 输出 一个整数
 * <p>
 * 思路： 根据题意，对于一个整数n，必然存在一个整数x，使得从n中分解出整数x可以使其最后获得最大乘积，这要求对n-x的分解也是最优解。
 * <p>
 * 我们用dp[i][j]表示从整数i分解出整数j的这种情况下，能达到的最大乘积。
 *
 * @author XIAO
 */
public class MaxMulti {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = largestProductOfN(n);
        System.out.println(result);
    }

    public static int largestProductOfN(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                if (j > i)
                    dp[i][j] = dp[i][i];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - j][j - 1] * j);
            }

        return dp[n][n];
    }
}
