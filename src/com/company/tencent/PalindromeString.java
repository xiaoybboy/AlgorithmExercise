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
		// TODO Auto-generated method stub
		return 0;
	}

}
