package com.company.qunar;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定两个均由大写英文字母组成的字符串（A-Z），检查这两个字符串是否仅包含相同的字母
 * 
 * 
 * 输入 两个字符串
 * 
 * 样例输入
 * 
 * FDJ DJDF
 * 
 * MIJJ MOJI
 * 
 * 输出 true / false
 * 
 * 样例输出
 * 
 * true
 * 
 * false
 * 
 * @author XIAO
 *
 */
public class StringHasSameCharacter {
	public static Boolean Com(String str1, String str2) {
		Boolean res = null;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		HashSet<Character> set1 = new HashSet<>();
		HashSet<Character> set2 = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set1.add(arr1[i]);
		}
		for (int j = 0; j < arr2.length; j++) {
			set2.add(arr2[j]);
		}
		if (set1.equals(set2)) {
			res = true;
		} else {
			res = false;
		}
		return res;

	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();

		System.out.println(Com(str1, str2));

	}
}
