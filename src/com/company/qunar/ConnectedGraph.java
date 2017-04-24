package com.company.qunar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 0 1 2 3
 * 
 * 4 5 6 7
 * 
 * 8 9 a b
 * 
 * c d e f
 * 上图是一个4X4的，其中每一个小块都有一个编号（0~f），现在我会任意给若干个不重复的编号（值范围0~f），你需要帮我判断这些编号所代表的图中的小块是否是联通的（即所有表示的小块是连成一片的）
 * 
 * 输入 输入数据有多组，每组占一行，包含多个0~f之间的字符，每个字符表示一个小块。
 * 
 * 样例输入
 * 
 * 0 1 5 6
 * 
 * 2 8 6 9
 * 
 * 5 f 9 d 6 e b
 * 
 * 输出
 * 
 * 如果该行给出的小块能组成联通图形，则打印pong，如果不能组成联通图形，则打印pang。
 * 
 * 每一行输出对应一行输入。
 * 
 * @author XIAO
 *
 */
public class ConnectedGraph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] strs = str.split("\\s+");
			int n = strs.length;
			int num[] = new int[n];
			Queue<Integer> q = new LinkedList<Integer>();
			ArrayList<Integer> list = new ArrayList<Integer>();// 保存输入的一行的字符
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(strs[i], 16);// 16进制转换成10进制
				list.add(num[i]);
			}

			q.offer(num[0]);
			list.remove(Integer.valueOf(num[0]));
			while (!q.isEmpty()) {
				int temp = q.poll();// 从队列首取出一个数
				if (list.contains(temp + 1)) {// 右边的数
					q.offer(temp + 1);
					list.remove(Integer.valueOf(temp + 1));
				}
				if (list.contains(temp - 1)) {// 左边的数
					q.offer(temp - 1);
					list.remove(Integer.valueOf(temp - 1));
				}
				if (list.contains(temp + 4)) {// 下边的数
					q.offer(temp + 4);
					list.remove(Integer.valueOf(temp + 4));
				}
				if (list.contains(temp - 4)) {// 上边的字符
					q.offer(temp - 4);
					list.remove(Integer.valueOf(temp - 4));
				}
			}
			if (list.isEmpty()) {
				System.out.println("pong");
			} else {
				System.out.println("pang");
			}
		}
		sc.close();
	}

}
