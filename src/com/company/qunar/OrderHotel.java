package com.company.qunar;

import java.util.Scanner;

/**
 * 你要出去旅游，有N元的预算住酒店，有M家酒店供你挑选，这些酒店都有价格X。
 * 需要你正好花完这N元住酒店（不能多，也不能少）最少能住几晚？返回最少住的天数，没有匹配的返回-1
 * 比如你有1000元，所有酒店都是大于1000的，则返回-1
 * 比如你有1000元，有1家1000元的，有1家300，有1家700。则最少能住1晚，最多住2晚（300+700）。返回1
 * 比如你有1000元，有1家387元，有1家2元，有一家611，则返回3（3家各住1天）
 * 比如你有1000元，有1家1元的，有一家2元的，有一家1001元的，则返回500（1元的1000天，2元的500天）
 * 
 * 输入
 * 
 * n个int，最后一个int为你拥有的钱，[0, n-2]为酒店的价格
 * 
 * 样例输入
 * 
 * 1001 1002 1003 2001 1000
 * 
 * 输出
 * 
 * 返回最少住的天数，没有匹配的返回-1 样例输出 -1
 * 
 * @author XIAO
 *
 */
public class OrderHotel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strs = str.split(" ");
		int n = strs.length - 1;
		int[] values = new int[n];
		for (int i = 0; i < n; i++)
			values[i] = Integer.valueOf(strs[i]);
		int money = Integer.valueOf(strs[n]);
		sc.close();

		// 动态规划
		int[] dp = new int[money + 1];// 当钱数为i时，能住的最小天数
		dp[0] = 0;// 钱为0时，能住的天数为0
		for (int i = 1; i <= money; i++) {
			int min = i;// 当钱为i时，最坏的情况 并且把钱完全花完 的情况是 ，每天花一块钱住一天
			for (int j = 0; j < n; j++)
				if (i >= values[j])// 是否把values[j]放进去
					min = Math.min(min, dp[i - values[j]] + 1);
			dp[i] = min;
		}
		if (dp[money] - dp[money - 1] != 1)
			System.out.print(dp[money]);
		else
			System.out.println(-1);
	}

}
