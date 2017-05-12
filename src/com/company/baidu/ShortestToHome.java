package com.company.baidu;

import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
 * 
 * 输入描述: 输入一个正整数N, N <= 50。
 * 
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 * 
 * 输出描述: 输出一个整数表示度度熊最少需要走的距离。
 * 
 * 输入例子:
 * 
 * 4
 * 
 * 1 4 -1 3
 * 
 * @author XIAO
 *
 */
public class ShortestToHome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] location = new int[n];

		for (int i = 0; i < location.length; i++) {
			location[i] = sc.nextInt();
		}

		int shortestRes = Integer.MAX_VALUE;
		for (int i = 1; i < location.length - 1; i++) {
			int temp = 0;// 把第i个点去掉后的总长度
			for (int j = 0; j < location.length - 1; j++) {
				if (i - 1 != j) {
					temp += Math.abs(location[j + 1] - location[j]);
				} else {
					temp += Math.abs(location[j + 2] - location[j]);
					j++;
				}
			}
			if (temp < shortestRes) {
				shortestRes = temp;
			}
		}

		System.out.println(shortestRes);
	}
}
