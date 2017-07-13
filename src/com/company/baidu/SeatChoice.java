package com.company.baidu;

import java.util.Scanner;

/**
 * 餐厅里有一张圆形的桌子，桌子上有n个座位，座位按照顺序从1到n编号，而且n号座位和1号座位相邻，每个座位都不一样。m个人一起去这家餐厅吃饭。
 * 
 * 为了更好地就餐，他们不想坐得太过拥挤，因此，不允许有任意两个人相邻。
 * 你知道一共有多少种不同的就坐方法吗？最后答案可能非常大，输出答案除以1000000007之后的余数。两种坐法不一样当且仅当存在一个人，在两种坐法中他坐在了不同的位置上。
 * 
 * 
 * 输入
 * 
 * 第一行一个数字T（T＜=10）表示测试数据的组数。
 * 
 * 对于每组测试数据，输入两个数n和m（1＜=n,m＜=100000）。
 * 
 * 样例输入 4 3 1 3 2 4 2 50 10
 * 
 * 输出
 * 
 * 每组数据输出一行，就坐的方案数，如果不存在合法的就坐方案，方案数为0。
 * 
 * 样例输出 3 0 4 128093084
 * 
 * 思路分析： 这是环形不相邻组合问题。链式不相邻组合问题我们已经详细证明过。
 * 
 * 主要思路是将环形不相邻组合变换为 链式不相邻组合。
 * 
 * 假设n=6,m=3, A={1,2,3,4,5,6},第一次选择，有6个位置，可以分为两种情况：
 * 
 * 1 剩下的数中不同时包含两个端点，假设选择2，则1，3不能选，只剩下{4，5，6}， 这个一个大小为3的链式不相邻问题。
 * 
 * 2 剩下的数中同时包含两个端点，假设选择3，则剩下{1，5，6}，其中1和5可以相邻，1和6不可相邻。 所以可以等价于{5，6，1}的链式 不相邻的问题。
 * 
 * @author XIAO
 *
 */
public class SeatChoice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();// 座位数
			int m = in.nextInt();// 人数
			if (m == 0 || m > (n / 2))
				System.out.println(0);
			else if (m == 1)
				System.out.println(n);
			else {
				long p = 1000000007;
				long result = n;
				for (int j = 1; j <= m - 1; j++) {
					result *= (n - m - j);
					result %= p;
				}
				System.out.println(result);
			}
		}
	}

}
