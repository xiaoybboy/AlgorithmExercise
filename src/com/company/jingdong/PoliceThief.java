package com.company.jingdong;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 有一条很长的队伍，队伍里面一共有n个人。所有的人分为三类：警察，小偷和普通人。将队伍里面的人从前到后由1到n编号，
 * 编号为i的人与编号为j的人的距离为i与j之差的绝对值。
 * 
 * 每一个警察有一个能力值x，表示他能够监视与他距离不超过x的所有人，小偷被警察发现当且仅当他被一个或多个警察监视到。
 * 你知道在整条队伍中，一共有多少个小偷会被警察发现吗？
 * 
 * 输入
 * 
 * 输入有两行，第一行一个数n(1<=n<=100000)，接下来一行有一个长度为n的字符串，依次表示队伍中的每一个人。
 * 
 * 如果某一位是1-9的某个数字x，表示这一位是一个能力值为x的警察；如果某一位是字符X表示这一位是小偷；
 * 
 * 如果某一位是字符#表示这是一个普通人。输入保证不会出现其它字符。
 * 
 * 样例输入
 * 
 * 9
 * 
 * X1X#2X#XX
 * 
 * 输出 输出一个数，整条队伍中被警察发现的小偷总数。
 * 
 * @author XIAO
 *
 */
public class PoliceThief {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] seq = sc.next().toCharArray();

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (seq[i] >= '1' && seq[i] <= '9') {
				int ability = seq[i] - '0';
				int low = Math.max(i - ability, 0);
				int high = Math.min(i + ability + 1, n - 1);
				for (int j = low; j < high; j++) {
					if (seq[j] == 'X') {
						set.add(j);
					}
				}
			}
		}
		System.out.println(set.size());
		sc.close();
	}

}
