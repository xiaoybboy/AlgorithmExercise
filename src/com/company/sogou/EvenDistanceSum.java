package com.company.sogou;

import java.util.Scanner;

/**
 * 定义两个大于2的偶数之间的距离，为这两个数之间质数的个数。从小到大输入n个大于2的偶数，输出所有数两两之间距离的总和
 * 
 * （应该有n*(n-1)/2个距离，输出总和就好)。
 * 
 * 输入 第一行是输入偶数的个数，最小为2，最大可能到几万。之后每行为一个偶数，最小是4，最大可能是几百万，不重复的升序排列。
 * 
 * 样例输入
 * 
 * 3
 * 
 * 4
 * 
 * 6
 * 
 * 12
 * 
 * 输出
 * 
 * 输入数据两两间距离的总和，这应该是一个不小于0的整数。
 * 
 * @author XIAO
 *
 */
public class EvenDistanceSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}

		int sum = 0;
		for (int j = 0; j < n; j++) {
			for (int k = j + 1; k < n; k++) {
				sum += distance(array[j], array[k]);
			}
		}
		sc.close();
		System.out.println(sum);
	}

	// 超时了。有待改进
	private static int distance(int n1, int n2) {
		int distance = 0;
		for (int i = n1 + 1; i < n2; i++) {
			if (isPrime(i)) {
				distance++;
			}
		}
		return distance;
	}

	private static boolean isPrime(int number) {
		boolean flag = true;// 是质数
		for (int j = 2; j < number - 1; j++) {
			if (number % j == 0) {
				flag = false;// 不是质数
				break;
			}
		}
		return flag;
	}
}
