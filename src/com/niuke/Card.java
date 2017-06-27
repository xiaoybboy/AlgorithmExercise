package com.niuke;

import java.util.Scanner;

/**
 * 牛牛有n张卡片排成一个序列.每张卡片一面是黑色的,另一面是白色的。初始状态的时候有些卡片是黑色朝上,
 * 
 * 有些卡片是白色朝上。牛牛现在想要把一些卡片翻过来,得到一种交替排列的形式,即每对相邻卡片的颜色都是不一样的。
 * 
 * 牛牛想知道最少需要翻转多少张卡片可以变成交替排列的形式。
 * 
 * 输入描述:
 * 
 * 输入包括一个字符串S,字符串长度length(3 ≤ length ≤50),其中只包含'W'和'B'两种字符串,分别表示白色和黑色。
 * 
 * 整个字符串表示卡片序列的初始状态。
 * 
 * 输出描述: 输出一个整数,表示牛牛最多需要翻转的次数。
 * 
 * @author XIAO
 *
 */
public class Card {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();

		int w = 0, b = 0;
		// 1,如果第一张放'W'
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (i % 2 == 0) {
				if (c == 'B') {
					w++;
				}
			} else {
				if (c == 'W') {
					w++;
				}
			}
		}

		// 2.如果第一张放‘B’
		for (int i = 0; i < line.length(); i++) {
			char c2 = line.charAt(i);
			if (i % 2 == 0) {
				if (c2 == 'W') {
					b++;
				}
			} else {
				if (c2 == 'B') {
					b++;
				}
			}
		}
		System.out.println(Math.min(b, w));
	}
}
