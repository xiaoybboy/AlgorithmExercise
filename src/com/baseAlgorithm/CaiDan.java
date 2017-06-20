package com.baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//第一行为价格上限n，想点菜的个数k，以及菜品个数m
public class CaiDan {
	private static int num = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxprices = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();

		int[] price = new int[m];
		for (int i = 0; i < m; i++) {
			price[i] = sc.nextInt();
		}
		ArrayList<Integer> prices = new ArrayList<Integer>();
		for (int i = 0; i < price.length; i++) {
			prices.add(price[i]);
		}

		backtracking(maxprices, k, prices);
		System.out.println(num);
	}

	public static void backtracking(int maxprice, int k, List<Integer> price) {
		if (k == 0) {
			num++;
			return;
		}
		for (int i = 0; i < price.size(); i++) {
			int temp = price.get(i);
			maxprice -= temp;
			price.remove(i);
			backtracking(maxprice, k - 1, price);
			maxprice += temp;
			price.add(i, temp);
		}
	}

}
