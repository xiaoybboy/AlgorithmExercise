package com.company.tencent;

import java.util.Scanner;

/**
 * 小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。 你能帮帮小Q吗？
 * 
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.对于每组数据，输出移位后的字符串。
 * 
 * 思路：使用冒泡排序的思路
 * 
 * @author XIAO
 *
 */
public class MoveCapitalBack {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			char[] chars = str.toCharArray();
			int length = chars.length;
			// 冒泡排序的方法，交换大小写字母的位置
			for (int i = 0; i < length - 1; i++)
				for (int j = 0; j < length - 1 - i; j++) {
					if ((chars[j] >= 'A' && chars[j] <= 'Z') && (chars[j + 1] < 'A' || chars[j + 1] > 'Z')) {
						char temp = chars[j];
						chars[j] = chars[j + 1];
						chars[j + 1] = temp;
					}
				}
			System.out.println(String.valueOf(chars));
		}
		scan.close();
	}

}
