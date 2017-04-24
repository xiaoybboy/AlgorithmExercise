package com.company.qunar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，
 * 
 * 请实现以下函数int[][] merge(int[][]dateRangePrices)，输入是某个酒店多个日期段的价格，
 * 
 * 每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，比如[0, 19, 300], [10, 40, 250]
 * 
 * 分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准，
 * 
 * 请以以下规则合并并输出合并结果：
 * 
 * 1.相邻两天的价格如果相同，那么这两个日期段应该合并
 * 
 * 2.合并的结果应该以起始日期从小到大排序
 * 
 * 
 * 输入 [0, 100, 300], [40, 50, 350]
 * 
 * 样例输入
 * 
 * 1 1 100
 * 
 * 2 3 100
 * 
 * 4 5 110
 * 
 * 输出 [0, 39, 300], [40, 50, 350], [51, 100, 300]
 * 
 * 样例输出
 * 
 * [1, 3, 100],[4, 5, 110]
 * 
 * @author XIAO
 *
 */
public class HotelPriceMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<>();

		while (sc.hasNext()) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int price = sc.nextInt();
			for (int i = start; i <= end; i++) {
				map.put(i, price);
			}
		}
		int min = Collections.min(map.keySet());
		int max = Collections.max(map.keySet());
		int start = min;
		int end = min + 1;
		StringBuffer s = new StringBuffer();
		while (end <= max + 1) {
			if (map.getOrDefault(start, -1) >= 0) {
				if (map.get(start) == map.getOrDefault(end, -1)) {
					end++;
				} else {
					int[] arr = new int[] { start, end - 1, map.get(start) };
					s.append(Arrays.toString(arr) + ",");
					start = end;
					end++;
				}
			} else {
				start++;
				end++;
			}
		}
		System.out.println(s.toString().substring(0, s.length() - 1));
		sc.close();
	}
}
