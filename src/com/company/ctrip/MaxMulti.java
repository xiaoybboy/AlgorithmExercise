package com.company.ctrip;

import java.util.Scanner;

/**
 * 有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
 * 
 * 输入
 * 
 * 一个整数
 * 
 * 样例输入
 * 
 * 15
 * 
 * 输出 一个整数
 * 
 * @author XIAO
 *
 */
public class MaxMulti {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = largestProductOfN(n);
		System.out.println(result);
	}

	// 动态规划
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
