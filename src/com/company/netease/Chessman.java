package com.company.netease;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/***
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并
 * 将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.
 * 
 * 输入描述: 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 * 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)
 * 
 * 输出描述:
 * 
 * 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格
 * 
 * 如样例所示:
 * 
 * 对于1个棋子: 不需要操作
 * 
 * 对于2个棋子: 将前两个棋子放在(1, 1)中
 * 
 * 对于3个棋子: 将前三个棋子放在(2, 1)中 对于4个棋子: 将所有棋子都放在(3, 1)中
 * 
 * 输入例子1:
 * 
 * 4
 * 
 * 1 2 4 9
 * 
 * 1 1 1 1
 * 
 * 输出例子1:
 * 
 * 0 1 3 10
 * 
 * @author XIAO
 *
 */
public class Chessman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			y[i] = sc.nextInt();
		sc.close();

		StringBuffer buffer = new StringBuffer();
		buffer.append(0);
		for (int k = 2; k <= n; k++) {
			int sum = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tempSum = 0;
					PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							return o2 - o1;
						}
					});

					for (int a = 0; a < n; a++) {
						int distance = Math.abs(x[a] - x[i]) + Math.abs(y[a] - y[j]);
						tempSum += distance;
						heap.add(distance);
						if (heap.size() > k) {
							tempSum -= heap.poll();
						}
					}
					sum = Math.min(sum, tempSum);
				}
			}
			buffer.append(" " + sum);
		}
		System.out.println(buffer.toString());
	}
}
