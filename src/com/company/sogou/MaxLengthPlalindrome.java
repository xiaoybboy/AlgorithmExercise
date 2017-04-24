package com.company.sogou;

import java.util.Scanner;

/**
 * 求一个字符串的最大回文前缀长度。回文是指正反方向读起来都一样的字符串，比如“abcdcba”就是一个回文。
 * 
 * 
 * 输入 一个文本文件，至少包含一个字节。每个字节是一个字符。最大长度可能有几十万字节。
 * 
 * 样例输入
 * 
 * sogou 输出
 * 
 * 最大回文前缀的长度。
 * 
 * 样例输出
 * 
 * 1
 * 
 * @author XIAO
 *
 */
public class MaxLengthPlalindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int max = getChildLen(str);
		System.out.println(max);
		sc.close();
	}

	public static int getChildLen(String str) {
		int n = str.length();

		int begin = 0;
		int end = n - 1;
		while (begin < end) {
			if (str.charAt(begin) == str.charAt(end)) {
				begin++;
				end--;
			} else {
				begin = 0;
				n--;
				end = n - 1;
			}
		}

		return n;
	}

	// 另一种方式，和上面思路相同,未AC,有待考虑
	public static int getChildLen2(String str) {
		int n = str.length();
		int maxLength = 0;
		for (int i = n - 1; i >= 1; i--) {
			String temp = str.substring(0, i);
			StringBuffer buffer = new StringBuffer(temp);
			if (buffer.reverse().toString().equals(temp)) {
				maxLength = temp.length();
				break;
			}
		}
		return maxLength;
	}
}
