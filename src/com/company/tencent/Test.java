package com.company.tencent;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
				System.out.println(array[i]);
			}
		}
	}
}
