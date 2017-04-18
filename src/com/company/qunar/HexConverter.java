package com.company.qunar;

import java.util.Scanner;

/**
 * 用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法。需要你写一个方法，将用a-z表示的26进制数值的字符串，转化为对应的10进制数值。
 * 
 * 输入 输入数据有多组，每组占一行，包含多个a-z之间的字符。
 * 
 * 样例输入
 * 
 * ba
 * 
 * bcd
 * 
 * gibbon
 * 
 * goodboy
 * 
 * 输出 所对应表示的10进制数。
 * 
 * @author XIAO
 *
 */
public class HexConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();

			char[] strarray = str.toCharArray();
			int n = strarray.length;
			long res = 0;
			for (int i = 0; i < n; i++) {
				long temp = strarray[i] - 'a';
				res += Math.pow(26, n - i - 1) * temp;
			}
			
			System.out.println(res);
		}
	}
}
