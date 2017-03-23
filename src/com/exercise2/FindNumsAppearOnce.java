package com.exercise2;

import java.util.HashMap;

public class FindNumsAppearOnce {
	public static void main(String[] args) {
		int[] array = { 2, 4, 3, 6, 3, 2, 5, 5 };
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new FindNumsAppearOnce().FindNumsAppearOnceArray(array, num1, num2);
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}

	public void FindNumsAppearOnceArray(int[] array, int num1[], int num2[]) {
		if (array == null || array.length == 0) {
			return;
		}
		boolean flag = true;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				int times = map.get(array[i]);
				times++;
				map.put(array[i], times);
			} else {
				map.put(array[i], 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			int times = map.get(array[i]);
			if (times == 1) {
				if (flag == true) {
					num1[0] = array[i];
					flag = false;
				} else {
					num2[0] = array[i];
				}

			}
		}
	}
}
