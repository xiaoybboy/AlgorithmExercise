package com.company.ctrip;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个整形数组，请写一个算法，找到第一个仅出现一次的数组元素，复杂度O(n) 。
 * 
 * 输入 给定一整形数组，数组元素若干
 * 
 * 样例输入
 * 
 * 1,1,2,2,3,3,4,4,5,6,6,8,9,9
 * 
 * 输出
 * 
 * 第一个仅出现一次的元素
 * 
 * @author XIAO
 *
 */
public class FindFirstAppearOnceInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		String[] sArray = s.split(",");
		int[] nums = new int[sArray.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(sArray[i]);
		}

		int res = findOnlyOneElment(nums);
		System.out.println(res);
	}

	private static int findOnlyOneElment(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == 1) {
				res = nums[i];
				break;
			}
		}
		return res;
	}
}
