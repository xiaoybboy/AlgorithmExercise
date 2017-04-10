package com.company.netease;

import java.sql.SQLClientInfoException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 * 
 * 输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50)
 * 
 * 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
 * 
 * 思路：借助一个双端队列，从后往前以此插入，遇到重复的跳过
 * 
 * @author XIAO
 *
 */
public class RemoveRepeatElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seq = new int[n];

		for (int i = 0; i < seq.length; i++) {
			seq[i] = sc.nextInt();
		}

		Deque<Integer> queue = new ArrayDeque<>();
		// 注意从后面向前插入，保证是最后一个重复元素保留
		for (int i = seq.length - 1; i >= 0; i--) {
			if (!queue.contains(seq[i])) {
				queue.offerFirst(seq[i]);
			}
		}

		// 输出queue里面的元素
		int size = queue.size();
		for (int j = 0; j < size; j++) {
			System.out.println(queue.pollFirst());
		}

	}

}
