package com.test2;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author XIAO
 *
 */

public class GetUglyNumber {
	public int GetUglyNumber_Solution(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] result = new int[index];
		result[0] = 1;
		int i2 = 0, i3 = 0, i5 = 0;// i2,i3,i5分别记录丑数的因子中2,3,5的个数
		for (int i = 1; i < index; i++) {
			result[i] = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
			if (result[i] == result[i2] * 2) {
				i2++;
			}
			if (result[i] == result[i3] * 3) {
				i3++;
			}
			if (result[i] == result[i5] * 5) {
				i5++;
			}
		}
		return result[index - 1];
	}

	private int min(int i, int j) {
		return i > j ? j : i;
	}
}
