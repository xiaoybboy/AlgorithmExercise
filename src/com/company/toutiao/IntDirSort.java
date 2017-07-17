package com.company.toutiao;

import java.util.Scanner;

/**
 * 给定整数n和m，将1到n的这n个整数按字典序排列之后，求其中的第m个数字。
 * 
 * 对于n = 11，m = 4，按字典序排列依次为
 * 
 * 1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9，因此第4个数字为2。
 * 
 * 
 * 输入
 * 
 * 输入仅包含两个整数n和m。
 * 
 * 样例输入
 * 
 * 11 4
 * 
 * 输出
 * 
 * 输出仅包括一行，即所求排列中的第m个数字。
 * 
 * 样例输出 2
 * 
 * @author XIAO
 *
 */
public class IntDirSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();

		long ans = 1;
		m--;
		while (m != 0) {
			long num = 0;
			long s = ans;
			long e = ans + 1;
			while (s <= n) {
				num += Math.min(n + 1, e) - s;
				s *= 10;
				e *= 10;
			}
			if (num <= m) {
				m -= num;
				ans++;
			} else {
				ans *= 10;
				m--;
			}
		}
		System.out.println(ans);

	}

}
