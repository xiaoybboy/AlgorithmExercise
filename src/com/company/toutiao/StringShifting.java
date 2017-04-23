package com.company.toutiao;

import java.util.Scanner;

/**
 * 我们规定对一个字符串的shift操作如下：
 * 
 * shift(“ABCD”, 0) = “ABCD”
 * 
 * shift(“ABCD”, 1) = “BCDA”
 * 
 * shift(“ABCD”, 2) = “CDAB”
 * 
 * 换言之, 我们把最左侧的N个字符剪切下来, 按序附加到了右侧。
 * 给定一个长度为n的字符串，我们规定最多可以进行n次向左的循环shift操作。如果shift(string, x) = string (0＜= x ＜n),
 * 我们称其为一次匹配(match)。求在shift过程中出现匹配的次数。
 * 
 * 输入
 * 
 * 输入仅包括一个给定的字符串，只包含大小写字符。
 * 
 * 样例输入
 * 
 * byebyebye
 * 
 * 输出 输出仅包括一行，即所求的匹配次数。
 * 
 * @author XIAO
 *
 */
public class StringShifting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int num = 1;
		char a = s.charAt(0);
		char b = s.charAt(s.length() - 1);
		if (s.length() < 700000)
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == a && s.charAt(i - 1) == b) {
					String temp = s.substring(i) + s.substring(0, i);
					if (temp.equals(s))
						num++;
				}
			}
		System.out.println(num);
		scanner.close();
	}

}
