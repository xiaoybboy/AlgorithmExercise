package com.baseAlgorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
 * 
 * @author XIAO
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int max = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), k);
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> temp = list.get(i);
			int mul = 1;
			for (int j = 0; j < temp.size(); j++) {
				mul *= temp.get(i);
			}
			if (mul > max) {
				max = mul;
			}
		}
		System.out.println(max);
		sc.close();
	}

	private static ArrayList<ArrayList<Integer>> backtrack(ArrayList<ArrayList<Integer>> list,
			ArrayList<Integer> tempList, int k) {
		if (k == 0) {
			list.add(tempList);
		}
		for (int i = 1; i <= k; i++) {
			tempList.add(i);
			backtrack(list, tempList, k - i);
			tempList.remove(tempList.size() - 1);
		}
		return list;
	}

}
