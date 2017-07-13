package com.company.jingdong;

import java.util.Scanner;

/**
 * 4和7是两个幸运数字，我们定义，十进制表示中，每一位只有4和7两个数的正整数都是幸运数字。前几个幸运数字为：4,7,44,47,74,77,444,447...
 * 现在输入一个数字K，输出第K个幸运数。
 * 
 * 输入
 * 
 * 第一行一个数字T（T<=1000）表示测试数据的组数。对于每组测试数据，输出一个数K
 * 
 * 样例输入
 * 
 * 3 5 100 1000000000
 * 
 * 输出
 * 
 * 每组数据输出一行，第K个幸运数。
 * 
 * 样例输出 74 744747 77477744774747744747444444447
 * 
 * 思路 http://blog.csdn.net/zengzhen_CSDN/article/details/52450129
 * 使用完全二叉树的思想，假设根节点为第0个数，值为-1；第1个数值为4，第2个数值为7，第3个数值为4，第4个数值为7，以此类推，
 * 即第奇数个数值为4，第偶数个数值为7。同时将其转为完全二叉树，如图所示：
 * 
 * 于是第k个幸运数就是从位置为k的叶子结点向上遍历直到根节点的左或右子节点的路径。根据完全二叉树的性质，可以由子节点的位置求得其父节点的位置。
 * 
 * 若子节点是奇数位置n，则其父节点是(n-1)/2；若子节点是偶数位置，则其父节点是(n-2)/2。遍历过程中拼接字符串即可得到幸运数。
 * 
 * @author XIAO
 *
 */
public final class LuckyNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			long k = sc.nextLong();
			StringBuilder sb = new StringBuilder();

			while (k > 0) {
				if ((k & 1) == 1) {// 如果k是奇数
					sb.append('4');
					k = (k - 1) / 2;// 向上回溯寻找父节点
				} else {// 偶数
					sb.append('7');
					k = (k - 2) / 2;
				}
			}

			System.out.println(sb.reverse());
		}

	}
}
