package com.company.didi;

import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * <p>
 * 输入描述: 输入为两行: 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 * 第二行为n个正整数A[i](32位整数)，以空格隔开。
 * <p>
 * 输出描述: 输出所求的方案数
 * <p>
 * 输入例子1: 5 15 5 5 10 2 3
 * <p>
 * 输出例子1: 4
 * <p>
 *  解：此题使用递归的遍历方法也可以解决，但是会超时  dp解决：dp[i][j]表示用前i个值组成和为j的方案个数
 *
 * @author XIAO
 * @create 2017-09-06 15:13
 **/
public class ArraySumCount {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = s.nextInt();
		int i, j;
		int arr[] = new int[n];
		for (i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		// dp[i][j]表示用前i个值组成和为j的方案个数
		long[][] dp = new long[n][sum + 1];
		dp[0][0] = 1;
		if (arr[0] <= sum) {
			dp[0][arr[0]] = 1;
		}

		for (i = 1; i < n; i++) {
			for (j = 0; j <= sum; j++) {
				// 第j个数不放入
				if (j - arr[i] < 0) {
					dp[i][j] += dp[i - 1][j];
				} else {// 把第j个数放入
					dp[i][j] += dp[i - 1][j - arr[i]] + dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n - 1][sum]);
	}
}
