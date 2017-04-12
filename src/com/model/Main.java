package com.model;

import java.util.Scanner;

/**
 * 题目描述： 拼图，是一个老少皆宜的益智游戏，在打乱的3*3的范围中，玩家只能每次将空格(0)和相邻的数字格（上、下、左、右）交换，
 * 
 * 最终调整出一个完整的拼图。 完整拼图为：
 * 
 * 1 2 3
 * 
 * 4 5 6
 * 
 * 7 8 0
 * 
 * @author XIAO
 *
 */
public class Main {

	/* 请完成下面这个函数，实现题目要求的功能 */
	/* 当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
	/****************************** 开始写代码 ******************************/

	/****************************** 结束写代码 ******************************/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String numbers = new String();
		for (int rows = 3; rows > 0; rows--) {
			for (String n : scan.nextLine().split(" ")) {
				numbers += n;
			}
		}
		System.out.println(numbers);
		// int res = run(numbers);

		// System.out.println(String.valueOf(res));
	}
}
