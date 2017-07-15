package com.company.jingdong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 小B曾经酷爱网络游戏，整日通宵达旦的玩游戏，导致身体素质急剧下降，因此下决心痛改前非，远离一切电子产品，并通过远足爬山的方式改变生活方式
 * 
 * 并提高身体素质。由于担心对身体造成太大的负荷，他总是选择最平坦的路径，并记录每天的行程情况及达到的最高海拔，使得连续两天之间的海拔之差
 * 
 * 最多为一个单位。不幸的是，在行程结束时，他不小心掉进河里，造成部分记录信息遗失。他想知道自己行程中可能达到的最高海拔，你是否能够帮忙？
 * 
 * 输入
 * 
 * 输入有若干组，每组的第一行为空格分隔的两个整数n和m，1< =n< =10^8, 1< =m<
 * =10^5，分别表示行程天数以及未遗失的记录数。随后紧跟m行，每行为空格分隔的两个整数d和h，1< =d< =n, 0< =h<
 * =10^8，表示行程的第几天及当天达到的最高海拔。
 * 
 * 样例输入
 * 
 * 8 2
 * 
 * 2 0
 * 
 * 7 0
 * 
 * 8 3
 * 
 * 2 0
 * 
 * 7 0
 * 
 * 8 3
 * 
 * 输出 对每组输入，如果记录是可能的，则在单独的行中输出可能达到的最高海拔，否则输出字符串“IMPOSSIBLE”（不含引号）。
 * 
 * 样例输出
 * 
 * 2
 * 
 * IMPOSSIBLE
 * 
 * 算法思想： 如果第一个记录不是第一天，则第一天的最大记录为天数间隔+第一个记录的高度。
 * 如果最后一个记录不是最后一天，则最后的一天的最大记录为天数间隔+最后记录的高度。
 * 
 * 中间的数据的最大高度为（左边的高度+右边的高度+天数间隔）/2
 * 
 * 如果任意两条记录之间的高度差大于天数差，则是非法的记录
 * 
 * @author XIAO
 *
 */

class Record {
	int day;
	int high;

	public Record(int day, int high) {
		this.day = day;
		this.high = high;
	}
}

public class Climbing {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			int m = cin.nextInt();
			Record[] record = new Record[m];
			for (int i = 0; i < m; i++) {
				int day = cin.nextInt();
				int high = cin.nextInt();
				record[i] = new Record(day, high);
			}
			Arrays.sort(record, new Comparator<Record>() {
				public int compare(Record r1, Record r2) {
					return r1.day - r2.day;
				}
			});
			// 检验合法性
			boolean isValid = true;
			for (int i = 1; i < m; i++) {
				int gapDay = Math.abs(record[i].day - record[i - 1].day);
				int gapHeight = Math.abs(record[i].high - record[i - 1].high);
				if (gapHeight > gapDay) {
					System.out.println("IMPOSSIBLE");
					isValid = false;
					break;
				}
			}
			if (isValid) {
				int left = (record[0].day - 1) + record[0].high;
				int right = (n - record[m - 1].day) + record[m - 1].high;
				int max = Math.max(left, right);
				for (int i = 0; i < m - 1; i++) {
					int temp = (record[i].high + record[i + 1].high + Math.abs(record[i + 1].day - record[i].day)) / 2;
					max = Math.max(temp, max);
				}
				System.out.println(max);
			}
		}
	}
}
