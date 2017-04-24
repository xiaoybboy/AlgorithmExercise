package com.company.qunar;

import java.util.Scanner;

/**
 * 给定一个数字，获取大于此数字的下一个数字X， 要求 X 为对称数字
 * 
 * 
 * 输入
 * 
 * 随机输入的自然数n
 * 
 * 样例输入
 * 
 * 451
 * 
 * 3840
 * 
 * 3363
 * 
 * 999
 * 
 * 输出 对于每个测试实例，要求输出大于n的下一个对称数字
 * 
 * 样例输出
 * 
 * 454
 * 
 * 3883
 * 
 * 3443
 * 
 * 1001
 * 
 * @author XIAO
 *
 */
public class FindNextSymmetricNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt() + 1;
		String string = String.valueOf(number);
		while (!isSymmetry(string)) {
			number++;
			string = String.valueOf(number);
		}
		System.out.println(number);
		sc.close();
	}

	private static boolean isSymmetry(String string) {
		String newString = new StringBuffer(string).reverse().toString();
		if (string.equals(newString)) {
			return true;
		}
		return false;
	}
}
