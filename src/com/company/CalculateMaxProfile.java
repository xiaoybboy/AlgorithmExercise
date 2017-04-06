package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 * 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 * 
 * 输入例子: 3,8,5,1,7,8
 * 
 * 输出例子: 12
 * 
 * 思路：把数组分成两部分，计算分别计算每部分的最大收益。动态规划的方法
 * 
 * @author XIAO
 *
 */
public class CalculateMaxProfile {
	public int calculateMax(int[] prices) {
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < prices.length; i++) {
			temp = getMax(prices, 0, i) + getMax(prices, i, prices.length - 1);
			if (temp > sum) {
				sum = temp;
			}
		}
		return sum;
	}

	// 求最大start到end之间的最大利润函数
	// 动态规划
	public int getMax(int[] prices, int start, int end) {
		int min = prices[start];
		int max = 0;
		// 循环的时候，同时寻找最小值和最大差值，注意：时间不能倒流
		for (int i = start + 1; i <= end; i++) {
			if (prices[i] < min) {
				min = prices[i];// 最小的买入价格,辅助用于找到最大收益
			}
			if (prices[i] - min > max) {
				max = prices[i] - min;// 最大的收益
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		int[] prices = new int[list.size()];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = list.get(i);
			System.out.println(prices[i]);
		}
		System.out.println(new CalculateMaxProfile().calculateMax(prices));

	}
}
