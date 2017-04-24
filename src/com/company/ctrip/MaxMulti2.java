package com.company.ctrip;

import java.util.Scanner;

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
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				//
				dp[i][j] = Math.max(dp[i - j][j - 1] * j, dp[i - 1][j - 1]);
			}
		}
		return dp[n][n];
	}
}
