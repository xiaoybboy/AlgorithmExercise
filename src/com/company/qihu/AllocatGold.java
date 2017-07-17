package com.company.baidu;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * A、B两伙马贼意外地在一片沙漠中发现了一处金矿，双方都想独占金矿，但各自的实力都不足以吞下对方，经过谈判后，双方同意用一个公平的方式来处理这片金矿。处理的规则如下：他们把整个金矿分成n段，由A、B开始轮流从最左端或最右端占据一段，直到分完为止。
 * 马贼A想提前知道他们能分到多少金子，因此请你帮忙计算他们最后各自拥有多少金子?（两伙马贼均会采取对己方有利的策略）
 * 
 * 
 * 输入
 * 测试数据包含多组输入数据。输入数据的第一行为一个正整数T(T<=20)，表示测试数据的组数。然后是T组测试数据，每组测试数据的第一行包含一个整数n，下一行包含n个数（n
 * <= 500 ），表示每段金矿的含金量，保证其数值大小不超过1000。
 * 
 * 样例输入
 * 
 * 2
 * 
 * 6
 * 
 * 4 7 2 9 5 2
 * 
 * 10
 * 
 * 140 649 340 982 105 86 56 610 340 879
 * 
 * 输出 对于每一组测试数据，输出一行"Case #id: sc1
 * sc2"，表示第id组数据时马贼A分到金子数量为sc1，马贼B分到金子数量为sc2。详见样例。
 * 
 * 样例输出
 * 
 * Case #1: 18 11
 * 
 * Case #2: 3206 981
 * 
 * @author XIAO
 *
 */
public class AllocatGold {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int k = 1; k <= t; k++) {
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			int[] res = compute(nums, n);
			System.out.println(String.format("Case #%d: %d %d", k, res[0], res[1]));

		}
		in.close();
	}

	public static int[] compute(int[] nums, int n) {
		int[][] dp = new int[n + 1][n + 1];// dp[i][j]表示从区间i到j之间的金子段能取得的最大值
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i][i] = nums[i - 1];
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for (int i = n - 1; i > 0; i--) {
			for (int j = i; j <= n; j++) {
				dp[i][j] = sum[j] - sum[i - 1] - Math.min(dp[i + 1][j], dp[i][j - 1]);
			}
		}
		return new int[] { dp[1][n], sum[n] - dp[1][n] };
	}
}
