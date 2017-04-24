package com.company.qunar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//思路：对酒店价格进行排序，从后往前 依次寻找能够放入的价格，则一定是最少的天数。
//这样只需要一次就可以找到最少天数

/**
 * 如果全部递归，会超时
 */

/**
 * 回溯法
 * 
 * @author XIAO
 *
 */
public class OrderHotel2 {

	public static int min = 0;// 全局最少天数
	public static int temp = 0;// 当前天数
	public static boolean flag = true;

	// 回溯法
	public static void searchMin(ArrayList<Integer> list, int curMoney) {
		if (curMoney == 0) {
			if (min == 0) {
				min = temp;
				flag = false;// 第一次找到的天数就一定是最小天数
			}
			return;
		} else {
			for (int i = list.size() - 1; i >= 0 && flag; i--) {
				if (curMoney >= list.get(i)) {
					temp++;
					searchMin(list, curMoney - list.get(i));
					temp--;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		ArrayList<Integer> list = stringToArrlist(string);
		int num = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		Collections.sort(list);// 对酒店价格进行排序，从后往前 依次寻找能够放入的价格，则一定是最少的天数
		searchMin(list, num);
		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		scanner.close();

	}

	public static ArrayList<Integer> stringToArrlist(String string) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c != ' ') {
				stringBuilder.append(c);
			} else {
				list.add(Integer.parseInt(String.valueOf(stringBuilder)));
				stringBuilder.delete(0, stringBuilder.length());
			}
		}
		list.add(Integer.parseInt(String.valueOf(stringBuilder)));
		return list;
	}

}
