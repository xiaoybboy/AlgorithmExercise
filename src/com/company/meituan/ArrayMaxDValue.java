package com.company.meituan;

/**
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。 给定数组A及它的大小n，请返回最大差值。
 * 
 * 思路：贪心思路。
 * 
 * 遍历数组的时候，同时寻找最小值和最小差值
 * 
 * @author XIAO
 *
 */
public class ArrayMaxDValue {
	public int getDis(int[] A, int n) {
		int dis = 0;
		if (n > 1) {
			int min = A[0];
			for (int i = 1; i < n; i++) {
				if (min > A[i]) {// 寻找最小值
					min = A[i];
				}
				if (A[i] - min > dis) {// 寻找最小差值
					dis = A[i] - min;
				}
			}
		}
		return dis;
	}
}
