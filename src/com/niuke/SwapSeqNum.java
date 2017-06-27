package com.niuke;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 牛牛有一个长度为n的整数序列s,羊羊要在牛牛的序列中选择不同的两个位置,然后交换这两个位置上的元素。
 * 
 * 现在需要求出羊羊交换后可以得到的不同的序列个数。(注意被交换的两元素值可能相同)。
 * 
 * 如序列{1, 47},输出1.羊羊必须交换仅有的两个元素,得到序列{47, 1}。
 * 
 * 羊羊必须交换,不能保留原有的序列。 {1, 2, 1},输出3.羊羊通过交换可以得到{2, 1, 1},{1, 1, 2},{1, 2, 1}这三个序列。
 * 
 * 输入描述: 输入包括两行,第一行为一个整数n(2 ≤ n ≤ 50),即序列的长度。 第二行n个整数,表示序列的每个元素a_i(1 ≤ a_i ≤
 * 50),以空格分割。
 * 
 * 
 * 输出描述: 输出一个整数,表示羊羊可以得到的不同的序列个数
 * 
 * @author XIAO
 *
 */
public class SwapSeqNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		for (int i = 0; i < nums.length; i++) {
			buffer.append(nums[i]);
		}

		HashSet<String> res = new HashSet<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				StringBuffer temp = buffer;
				swap(temp, i, j);
				res.add(temp.toString());
			}
		}
		System.out.println(res.size());
	}

	/**
	 * 交换a,b位置字符
	 * 
	 * @param str
	 * @param a
	 * @param b
	 */
	public static void swap(StringBuffer str, int a, int b) {
		char temp = str.charAt(a);
		str.setCharAt(a, str.charAt(b));
		str.setCharAt(b, temp);
	}
}
