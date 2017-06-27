package com.company.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 
 * 输入描述: 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * 
 * 输出描述: 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * 
 * 输入例子:
 * 
 * 10
 * 
 * 10 10 10 10 20 20 30 30 40 40
 * 
 * @author XIAO
 *
 */
public class ThirdPriceHat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = sc.nextInt();
		}

		Arrays.sort(prices);
		int index = 1;// 不同价格的个数
		int currentPrice = prices[0];// 当前价格
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] != currentPrice) {
				index++;
				currentPrice = prices[i];
			}

			if (index == 3) {
				System.out.println(currentPrice);
				break;
			}
		}

		if (index < 3) {
			System.out.println(-1);
		}
		sc.close();
	}
}
