package com.company.leshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 真是一个无聊的夜晚啊，小B和小C在宿舍中实在无聊之极，因此决定玩一个数字游戏打发时间。小B首先开始，她给小C的问题是：
 * 
 * 给定任意一个整数，小C可以交换该数中任意的不同位，能够得到的最小数值是多少？前提是不能有前导0。
 * 
 * 小C很快就给出了一个答案，小B希望你来帮她检验答案的正确性，你能帮忙吗？
 * 
 * 
 * 
 * 输入 输入中有多组测试数据。
 * 
 * 每组测试数据的第一行为一个没有前导0的整数n（0=＜n =＜10^9），第二行为另一个整数m（0=＜m=＜10^9），小C给出的问题答案。
 * 
 * 样例输入
 * 
 * 3310
 * 
 * 1033
 * 
 * 4
 * 
 * 5
 * 
 * 输出 对每组测试数据，在单独的行中输出结果，若小C的答案是正确的，输出YES，否则输出NO。
 * 
 * 样例输出
 * 
 * YES
 * 
 * NO
 * 
 * @author XIAO
 *
 */
public class NumberGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String str = scan.nextLine();
			String s = scan.nextLine();
			char[] c = str.toCharArray();
			Arrays.sort(c);
			if (c[0] == '0') {
				for (int i = 1; i < c.length; i++)
					if (c[i] != 0) {// 交换第一个c[i]不为0的数字和c[0]的位置
						char t = c[i];
						c[i] = c[0];
						c[0] = t;
						break;
					}
			}
			String o = String.valueOf(c);
			if (o.equals(s)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
