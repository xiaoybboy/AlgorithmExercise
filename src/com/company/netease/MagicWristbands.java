package com.company.netease;

import java.util.Scanner;

/**
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面
 * 一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
 * 现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 * 
 * 输入数据包括两行：
 * 
 * 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 * 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 * 
 * 
 * 输出描述: 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 * 
 * @author XIAO
 *
 */
public class MagicWristbands {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		sc.close();

		for (int j = 0; j < k; j++) {
			int temp = numbers[0];
			for (int l = 0; l < numbers.length - 1; l++) {
				numbers[l] += numbers[l + 1];
				if (numbers[l] >= 100) {
					numbers[l] = numbers[l] % 100;
				}
			}
			numbers[numbers.length - 1] += temp;
			if (numbers[numbers.length - 1] >= 100) {
				numbers[numbers.length - 1] = numbers[numbers.length - 1] % 100;
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
