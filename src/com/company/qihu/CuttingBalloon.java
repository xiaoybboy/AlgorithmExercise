package com.company.qihu;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 小明买了一些彩色的气球用绳子串在一条线上，想要装饰房间，每个气球都染上了一种颜色，每个气球的形状都是各不相同的。我们用1到9一共9个数字表示
 * 不同的颜色，如12345则表示一串5个颜色各不相同的气球串。但小明希望得到不出现重复颜色的气球串，那么现在小明需要将这个气球串剪成多个较短的气球串，小明一共有多少种剪法？如原气球串12345的一种是剪法是剪成12和345两个气球串。
 * 注意每种剪法需满足最后的子串中气球颜色各不相同（如果满足该条件，允许不剪，即保留原串）。两种剪法不同当且仅当存在一个位置，在一种剪法里剪开了，
 * 而在另一种中没剪开。详见样例分析。
 * 
 * 
 * 输入 第一行输入一个正整数n（1≤n≤100000），表示气球的数量。
 * 第二行输入n个整数a1，a2，a3...an，ai表示该气球串上第i个气球的颜色。对于任意i，有1≤ai≤9。
 * 
 * 样例输入
 * 
 * 3
 * 
 * 1 2 3
 * 
 * 输出 输出一行，第一行输出一个整数，表示满足要求的剪法，输出最终结果除以1000000007后的余数。
 * 
 * 样例输出
 * 
 * 4
 * 
 * 思路：这题需要用到动态规划进行求解，我们不妨记一个数组dp[i]，表示这个数组前i个数组成的数组可以有多少种分法，数组初始全为0，特别的dp[0]初始为1。
 * 
 * 那么在计算dp[i+1]时，我们需要考虑第i+1个数可以和前面哪些数分到一起组成连续的子数组，
 * 
 * 比如第i+1个数可以和第i个数组成一组 ，但不能和第i-1个数分到一组，那么dp[i+1]=dp[i]+dp[i-1]
 * 
 * 上述公式解释：第i+1个数可以单独组成一组， 有：dp[i+1]+=dp[i]
 * 
 * 第i+1个数和第i个数组成一组，有：dp[i+1]+=dp[i-1]由于每个数的范围是1到9，
 * 所有最多只需要按照这种方法枚举第i+1个数前面的9个数即可停止。算法复杂度O(n*10)。
 * 
 * 简单解释：
 * 
 * 1.记数组dp[i]，表示长度为n的这个数组的前i个数组成的数组可以有多少种剪法。数组初始全为0。dp[1] = 1。
 * 那么在计算dp[i]时，我们需要考虑第i个数可以和前面的哪些数分到一组。
 * 
 * 1）第i个数自己一组，那么dp[i] += dp[i-1];
 * 2）第i个数和第i-1个数一组，这个需要考虑第i和第i-1个数能不能一组，当两个数字（气球的颜色）相同时，由于要求子串中不能出现重复数字，所以不能一起，此时dp[i]计算结束；当两个气球颜色不相同时，可以一组，那么dp[i]
 * += dp[i-2];
 * 
 * 3）依次类推。
 * 
 * @author XIAO
 *
 */
public class CuttingBalloon {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			HashSet<Integer> hs = new HashSet<>();// 从第i个倒数到第i-j个数字组成的序列
			// i 表示第i-1个 res[i]表示前i个数字的切分方法
			for (int j = i; j > 0; j--) {
				if (hs.contains(arr[j - 1])) {
					break;
				} else {
					hs.add(arr[j - 1]);
					res[i] = (res[i] + res[j - 1]) % 1000000007;
				}
			}
		}
		System.out.println(res[n]);
	}
}