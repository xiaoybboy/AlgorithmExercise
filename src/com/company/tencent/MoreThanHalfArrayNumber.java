package com.company.tencent;

import java.util.Arrays;

/**
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
 * 
 * 某个红包金额出现的次数超过了红包总数的一半。
 * 
 * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 * 
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。 若没有金额超过总数的一半，返回0。
 * 
 * 思路一：快速排序，取中间的那个数，一定是金额超过1/2总数的。复杂度0(nlogn)
 * 
 * 思路二：充分利用金额超过1/2总数条件，求局部连续次数最多的数字，一定是金额超过1/2总数的金额。复杂度O(n)
 *
 * 
 * @author XIAO
 *
 */
public class MoreThanHalfArrayNumber {
	public int getValue(int[] gifts, int n) {
		Arrays.sort(gifts);// 排序
		int res = gifts[n / 2];

		// 对结果进行验证
		int count = 0;
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == res) {
				count++;
			}
		}

		return count <= n / 2 ? 0 : res;
	}

	public int getValue2(int[] gifts, int n) {
		int temp = gifts[0];// 从第一个元素开始查找
		int times = 1;

		for (int i = 1; i < gifts.length; i++) {
			if (gifts[i] == temp) {// 如果与temp相等
				times++;
			} else {
				times--;// 不等则出现次数-1
				if (times == 0) {// 当出现次数==0的时候，重新选择temp,并初始化times=1
					temp = gifts[i];// 最后一次执行这句赋值的一定出现>n/2次的元素
					times = 1;
				}
			}
		}

		int count = 0;
		for (int j = 0; j < gifts.length; j++) {
			if (gifts[j] == temp) {
				count++;
			}
		}
		return count > n / 2 ? temp : 0;
	}
}
