package com.company.tencent;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？ 输出需要删除的字符个数。
 * 
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 
 * 思路：回文串的特点是，逆序输出和正序输出是一样的。所以这道题可以从这方面来考虑。
 * 
 * 如果将此字符串逆序输出，那么两个字符串的最长公共子序列将是最长的回文字符串，那么剩余的值将是要删除的字符个数。
 * 
 * @author XIAO
 *
 */
public class PalindromeString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(str.length() - getResult(str));
		}
	}

	private static int getResult(String str) {

		StringBuilder sb = new StringBuilder(str);
		String newStr = sb.reverse().toString();
		char[] c1 = str.toCharArray();
		char[] c2 = newStr.toCharArray();

		int n = str.length();
		int[][] dp = new int[n + 1][n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (c1[i - 1] == c2[j - 1]) { // 此处应该减1.
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][n];
	}

}
