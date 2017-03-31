package com.offer1;

public class ReorderArray {
	public void order(int[] array) {
		if (array == null) {
			return;
		}
		int i = 0;
		int j = array.length - 1;
		while (i <= j) {
			// 如果array[i]是偶数 且 array[j]是奇数，交换两者位置
			// 注意此时i 和 j 的值都不变
			if (isEven(array[i]) && !isEven(array[j])) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			} else if (!isEven(array[i]) && !isEven(array[j])) {
				i++;
			} else if (isEven(array[i]) && isEven(array[j])) {
				j--;
			} else {
				i++;
				j--;
			}
		}
	}

	// 判断n是不是一个偶数
	public boolean isEven(int n) {
		return (n % 2) == 0;
	}

	public static void main(String[] args) {
		ReorderArray array = new ReorderArray();
		int[] arr = { 1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10 };
		array.order(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
