package com.baseAlgorithm;

/**
 * 插入排序
 * 
 * @author XIAO
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = { 1, 5, 9, 3, 10, 7, 20, 8 };
		insertSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void insertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int currentValue = array[i];// 保存array[i]的值
			int index = i;// 插入位置
			for (int j = i - 1; j >= 0; j--) {
				if (array[j] > currentValue) {
					array[j + 1] = array[j];// 右移，腾出插入位置
					index--;
				} else {
					break;
				}
				array[index] = currentValue;
			}
		}
	}

}
