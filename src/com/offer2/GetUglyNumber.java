package com.offer2;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：一个丑数成以2/3/5，得到的还是一个丑数；有3个对列pos2/pos3/pos5，每次都取最小的数，放到数组中【小于7的数都是丑数】。
 *
 * 丑数必定是由若干个2，3，5相乘获得的，每个丑数乘2.3.5分别可以衍生出3个新丑数，但是会存在重复。所以定义三个指针分别代表乘2.3.5。
 * 开始都指向0，每次乘2.3.5，最小的值就是下一个丑数，那相应的指针也得++。在动态的比较中获得最小的丑数。
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
			result[i] = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
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
}
