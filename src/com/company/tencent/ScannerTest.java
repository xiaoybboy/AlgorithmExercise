package com.company.tencent;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
				System.out.println(array[i]);
			}
		}

		// JAVA，当键盘输入多行字符串时，如何停止输入。
		while (sc.hasNext()) {
			// 得到输入数据
			String input = sc.next();
			// 如果用户输入'end'则结束
			if (input.equals("end")) {
				break;
			}
		}
		sc.close();
	}
}
