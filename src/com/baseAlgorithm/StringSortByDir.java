package com.baseAlgorithm;

// 字符串按照字典排序
import java.util.Arrays;
import java.util.Collections;

public class StringSortByDir {

	public static void main(String[] args) {

		String demos[] = { "hello", "chenhj", "test", "中国" };
		// 方法一
		Arrays.sort(demos);

		for (int i = 0; i < demos.length; i++) {

			System.out.println(demos[i]);
		}
		// 方法二

		/*
		 * Arrays.sort(demos, new StringComparator());
		 * 
		 * for (String demo : demos) {
		 * 
		 * System.out.println(demo);
		 * 
		 * }
		 */
		Collections.sort(Arrays.asList(demos));

		for (int i = 0; i < demos.length; i++) {

			System.out.println(demos[i]);
		}

	}
}
