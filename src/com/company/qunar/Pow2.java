package com.company.qunar;

import java.util.Scanner;

/**
 * 判断一个数是否为2的次方，不能使用任何类库以及内置函数
 * 
 * 输入 一个int
 * 
 * 样例输入
 * 
 * 2
 * 
 * 9
 * 
 * 1024
 * 
 * 1000
 * 
 * 输出
 * 
 * boolean
 * 
 * @author XIAO
 *
 */
public class Pow2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int temp = sc.nextInt();
			boolean flag = true;
			while (temp != 1) {

				if (temp % 2 != 0) {
					flag = false;
				}
				temp = temp / 2;
			}
			System.out.println(flag);
		}
	}
}
