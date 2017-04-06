package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * A string s is LUCKY if and only if the number of different characters in s is
 * a fibonacci number. Given a string consisting of only lower case letters ,
 * output all its lucky non-empty substrings in lexicographical order. Same
 * substrings should be printed once.
 * 
 * 输入描述: a string consisting no more than 100 lower case letters.
 * 
 * 输出描述: output the lucky substrings in lexicographical order.one per line. Same
 * substrings should be printed once.
 * 
 * @author XIAO
 *
 */
public class LuckyString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(str);
		scanner.close();

		// 获得100以内的所有fibonacci数
		Set<Integer> fib = new HashSet<Integer>();
		for (int i = 0; i < 20; i++) {
			fib.add(fibonacci(i));
		}

		// 得到所有的子字符串
		Set<String> substr = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				substr.add(str.substring(i, j + 1));
			}
		}

		// 遍历所有的子字符串，获得字符串中不同字符个数
		Set<Character> characters = new HashSet<>();
		for (String substring : substr) {
			for (int i = 0; i < substring.length(); i++) {
				characters.add(substring.charAt(i));
			}
			if (fib.contains(characters.size())) {// 如果不同字符的数量是斐波那契数
				System.out.println(substring);
			}
			characters.clear();
		}

	}

	private static Integer fibonacci(int n) {
		if (n == 1 || n == 2) {
			return n;
		}
		int num1 = 1;
		int num2 = 2;
		int num3 = 0;
		for (int i = 3; i < n; i++) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
		}
		return num3;

	}

}
