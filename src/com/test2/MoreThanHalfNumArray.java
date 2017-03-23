package com.test2;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * 思路1：快速排序 思路2：找最大相邻重复出现的元素
 * 
 * @author XIAO
 *
 */
public class MoreThanHalfNumArray {
	/**
	 * 第一种思路
	 * 
	 * @param array
	 * @return
	 */
	public int MoreThanHalfNum_Solution(int[] array) {
		// 判断数组长度是否为0或者数组为null
		if (array.length == 0 || array == null)
			return 0;
		Arrays.sort(array);// 快速排序对数组进行排序
		int mid = array[(array.length) / 2];// 中间的元素

		// 对mid 进行验证
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (mid == array[i]) {
				count++;
			}
		}
		return count > (array.length / 2) ? mid : 0;
	}

	// 第二种思路，想了很久才想明白。关键是利用有一个数的出现次数大于数组长度的一半这个条件
	public int MoreThanHalfNum_Solution2(int[] array) {
		// 判断数组长度是否为0或者数组为null
		if (array.length == 0 || array == null)
			return 0;
		// 寻找相邻重复次数最多的元素
		int temp = array[0];// 从第一个元素开始找
		int times = 1;// 重复出现的次数
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				temp = array[i];// 最后一次赋值的必定是我们要找的元素
				times = 1;
			} else if (array[i] == temp) {
				times++;
			} else {
				times--;
			}
		}
		// 验证
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == temp) {
				count++;
			}
		}
		return count > (array.length / 2) ? temp : 0;
	}
}
