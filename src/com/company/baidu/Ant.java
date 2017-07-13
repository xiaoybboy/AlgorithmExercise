package com.company.baidu;

import java.util.Scanner;

/**
 * 有些蚂蚁在一条水平线上爬行，每只蚂蚁的速率都是1cm/s。蚂蚁爬到水平线的任何一个端点时会立刻掉下来，当两只蚂蚁碰到一起时他们都会立刻调头向相反方向移动。
 * 已知蚂蚁们在水平线上的初始位置，但不幸的是，它们初始的运动方向是不知道的。请计算所有蚂蚁从水平线上掉下来可能所需的最早和最晚的时间。
 * 
 * 
 * 输入 第一行有一个整数，表示有多少组测试数据。
 * 每组测试数据以两个整数开始：水平线长度(单位cm)和蚂蚁数，随后的一行中有n个整数，表示每只蚂蚁距水平线左端点的距离。所有的输入的整数都小于1000000而且用空格隔开。
 * 
 * 样例输入
 * 
 * 2
 * 
 * 10 3
 * 
 * 2 6 7
 * 
 * 214 7
 * 
 * 11 12 7 13 176 23 191
 * 
 * 输出 对于每组测试数据，在同一行输出两个整数，第一个表示所有蚂蚁从水平线上掉下来的最早时间，第二个表示最晚时间。
 * 
 * 样例输出 4 8 38 207
 * 
 * 解题思路：在给定的水平线上寻找两个值：一个值是距离某个端点最近，另一个值距离某个端点最远。输出这两个值。
 * 最远的距离也就是离着最近的端点的相反端点。比如：水平长度为10，则2的最近点是0，最远距离是10-2=8.
 * 
 * @author XIAO
 *
 */
public class Ant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 0; i < count; ++i) {
			int len = sc.nextInt();
			int num = sc.nextInt();
			int min = 0;
			int max = 0;
			for (int j = 0; j < num; ++j) {
				int tem = sc.nextInt();
				min = Math.max(min, Math.min(tem, len - tem));// 每只蚂蚁都向离自己近的一端移动
				max = Math.max(max, Math.max(tem, len - tem));
			}
			System.out.println(min + " " + max);
		}
	}
}
