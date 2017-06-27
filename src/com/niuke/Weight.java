package com.niuke;

import java.util.Scanner;

/**
 * 牛牛以草料为食。牛牛有一天依次遇到n堆被施展了魔法的草料,牛牛只要遇到一堆跟他当前相同大小的草料,它就会把草料吃完,
 * 
 * 而使自己的大小膨胀一倍。一开始牛牛的大小的是A,然后给出牛牛依次遇到的n堆草料的大小。请计算牛牛最后的大小。
 * 
 * 输入描述: 输入包括两行,第一行包含两个整数n和A(1 ≤ n ≤ 200, 1 ≤ A ≤ 1,000,000,000)
 * 第二行包括n个整数,表示牛牛依次遇到的草料堆大小a_i(1 ≤ a_i ≤ 1,000,000,000)
 * 
 * 输出描述: 输出一个整数,表示牛牛最后的大小。
 * 
 * @author XIAO
 *
 */
public class Weight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A = sc.nextInt();
		int[] size = new int[n];

		for (int i = 0; i < size.length; i++) {
			size[i] = sc.nextInt();
		}

		for (int i = 0; i < size.length; i++) {
			if (size[i] == A) {
				A = 2 * A;
			}
		}

		System.out.println(A);
	}
}
