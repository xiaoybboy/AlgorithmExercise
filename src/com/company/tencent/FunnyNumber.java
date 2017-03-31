package com.company.tencent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/***
 * 有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？
 * 
 * 思路： 1.先排序 ,因为排序之后，差值最小的肯定在相邻元素之间
 * 
 * 特殊情况：如果排完序之后发现数组中所有数都相同，直接输出结果 结果为：差最大个数 = 差最小个数 = （n * (n-1))/2;(两两组合)
 * 
 * 2.统计数组中每种数字的个数（这里用的map）
 * 
 * 3.计算差最小个数
 * 
 * 3.1.如果数组中没有重复数字，说明最小差不为0，最小差肯定是数组中相邻两个数的差 因此，一边遍历数组，计算并统计最小差。
 * 3.2.如果数组中有重复数字，说明最小差是0，此时，遍历一边map，数字个数不为0的 数字会产生最小差0，利用公式计算即可
 * 
 * 4.计算差最大个数 只有一种情况，最大值与最小值的两两组合，即最大值个数 * 最小值个数
 * 
 * @author XIAO
 *
 */
public class FunnyNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			int n = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
				System.out.println(array[i]);
			}

			// 1.排序
			Arrays.sort(array);

			// 如果排完序的数组中的元素全部相同，则直接输出结果
			if (array[0] == array[n - 1]) {
				int temp = n * (n - 1) / 2;// 有n * (n - 1) / 2差值相同
				System.out.println(temp);
				continue;
			}

			// 2.统计数组中每个数字的个数（这里用的Treemap）
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < array.length - 1; i++) {
				if (map.containsKey(array[i])) {
					map.put(array[i], map.get(array[i] + 1));
				} else {
					map.put(array[i], 1);
				}
			}

			// 3.求最小差值的个数
			int minres = 0;
			if (map.size() == n) {// 如果没有重复元素
				int mindvalue = Math.abs(array[1] - array[0]);// 初始化最小差值
				minres = 1;
				for (int i = 2; i < array.length - 1; i++) {
					int temp = Math.abs(array[i] - array[i] - 1);
					if (temp < mindvalue) {// 如果有比当前最小差值小的差值，更新最小差值
						mindvalue = temp;
						minres = 1;
					} else if (temp == mindvalue) {// 如果与当前最小差值相等，minres +1;
						minres++;
					}

				}
			} else {// 如果有重复元素，则最小差值一定为0
				for (int i = 0; i < array.length - 2; i++) {
					int temp = Math.abs(array[i + 1] - array[i]);
					if (temp == 0) {
						minres++;
					}
				}
			}

			// 求最大差个数，最大差值一定是最大的数与最小的数的差
			int maxres = 0;
			// 最小的数的个数,和最大数的个数
			int minAmount = map.get(array[0]);
			int maxAmount = map.get(array[n - 1]);

			maxres = minAmount * maxAmount;
			System.out.println(minres + " " + maxres);
		}
	}

}
