package com.company.qunar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 作为国内领先的酒店预订平台，去哪儿网为了广大用户能住到更舒适的酒店，根据实际用户的居住评价对各酒店进行动态评级和排名。去哪儿网会从酒店整体环境、客房舒适度、服务质量、配套设施和交通情况5的方面进行评价收集，并给与
 * 1-5 星的评分（整数）。现希望开发者编写程序根据一定的规则对酒店进行排序。规则如下：
 * 
 * 1.优先按照最低星数进行排序，最低星数高者居前。
 * 
 * 2.在最低星数相同时，按照平均星数排序，平均星数高者居前。
 * 
 * 3.如果最低星数和平均星数均相同，则序号（数据里出现的顺序编号，从0开始）小者居前。
 * 
 * 输入 第一行输入为酒店个数 n，下面 n（1 <= n <= 10000） 行，每行共5个数值，分别为5个方面的评分（均为 1-5 的整数）。
 * 
 * 样例输入
 * 
 * 5
 * 
 * 4 4 5 3 4
 * 
 * 3 3 3 3 3
 * 
 * 5 4 4 3 5
 * 
 * 5 5 5 5 5
 * 
 * 5 2 4 3 4
 * 
 * 输出 排序后的酒店序号（数据里出现的顺序编号，从0开始）
 * 
 * @author XIAO
 *
 */
public class HotelScore {
	public static class Hotel {
		public int min;// 最低星
		public int sum;
		public int index;// 序号

		Hotel(int a, int b, int c) {
			min = a;
			sum = b;
			index = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		Hotel[] nodes = new Hotel[num];
		for (int i = 0; i < num; i++) {
			String str = sc.nextLine();
			String[] strs = str.split(" ");
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				int data = Integer.parseInt(strs[j]);
				if (data < min)
					min = data;
				sum += data;
			}
			nodes[i] = new Hotel(min, sum, i);
		}
		sc.close();

		// 对所有的Hotel进行排序
		/*
		 * 如果要按照升序排序， 则o1 小于o2，返回-1（负数），相等返回0，01大于02返回1（正数）
		 * 
		 * 如果要按照降序排序 则o1小于o2，返回1（正数），相等返回0，01大于02返回-1（负数）
		 */

		Arrays.sort(nodes, new Comparator<Hotel>() {
			public int compare(Hotel node1, Hotel node2) {
				if (node1.min == node2.min) {
					if (node1.sum == node2.sum) {
						return node1.index - node2.index;// 按照索引升序排列
					} else {
						return node2.sum - node1.sum;// 按照平均值降序排列
					}
				} else {
					return node2.min - node1.min;// 按照星数降序排列
				}
			}
		});
		for (int i = 0; i < num; i++)
			System.out.print(nodes[i].index + " ");
	}

}
