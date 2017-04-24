package com.company.qunar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 班级中有很多学生，每个学生都有自己爱好，dota、篮球、打豆豆等等，站在爱好角度观察，假如兴趣相似度越高，友谊小船划得越远，
 * 
 * 现在每个英文字符a、b、c、......、z都代表一种兴趣爱好，并且字母顺序就是热爱程度，求爱好的最大相似度(最长公共子串)。
 * 
 * 输入 随机输入两个字符串，都是英文字母，不区分大小写
 * 
 * 样例输入
 * 
 * afhelk
 * 
 * afdzhelos
 * 
 * 输出
 * 
 * 输出“resullt=?”，没有匹配到返回“”，匹配到返回“slfl”字样
 * 
 * 样例输出
 * 
 * resullt=hel
 * 
 * @author XIAO
 *
 */
public class LCSSubString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str1 = scanner.next().toLowerCase();
			String str2 = scanner.next().toLowerCase();
			int[][] dp = getdp(str1, str2);
			int max = dp[0][0];
			int end = 0;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if (dp[i][j] > max) {
						end = i;// str1中最大子串的结束位置
						max = dp[i][j];
					}
				}
			}
			System.out.println("result=" + str1.substring(end - max + 1, end + 1));
			scanner.close();
		}
	}

	/**
	 * str1和str2的dp矩阵。dp[i][j]代表str1的前i个字符和str2的前j个字符的 最长公共子串 的最大长度
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static int[][] getdp(String str1, String str2) {
		int[][] dp = new int[str1.length()][str2.length()];
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(0))
				dp[i][0] = 1;// 第1列
		}
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) == str1.charAt(0))
				dp[0][i] = 1;// 第1行
		}
		for (int i = 1; i < str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp;
	}
}
