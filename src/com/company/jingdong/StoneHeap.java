package com.company.jingdong;

import java.util.Scanner;

/**
 * 小明得到了n个石头，他想把这些石头分成若干堆，每堆至少有一个石头。他把这些石堆排在一条直线上，他希望任意相邻两堆的石头数都不一样。小明最后的得分为石头数大于等于k的石堆数，问他最多能得多少分。
 * 严格地，小明把n个石头分成了m堆，每堆个数依次为a1，a2.....，am。要求满足： 1、ai≥1（1≤i≤m） 2、ai≠ai+1（1≤i＜m）
 * 3、a1+a2+...+am＝n 小明想知道中大于等于的数最多能有多少个？
 * 
 * 
 * 输入
 * 
 * 输入两个数n, k。
 * 
 * 样例输入 5 1
 * 
 * 输出 输出最大的得分 样例输出 3
 * 
 * 思路：理想情况为 k、k+1、k、k+1、k、k+1、k、k+1…，这样子的得分最高
 * 
 * @author XIAO
 *
 */
public class StoneHeap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 分堆按k,k+1,k,k+1,k....
		// n=k+0时刚好得1分，n=2k+1得2分，n=3k+1得3分，n=4k+2得4分
		// n=xk+（int）x/2时刚好得x分,求x

		int ans = n / (2 * k + 1);// n里面有多少个2k+1,每一个2k+1是两堆
		ans *= 2;
		if (n % (2 * k + 1) >= k)// 剩余的石头是否大于k
			ans++;
		System.out.println(ans);
	}

}
