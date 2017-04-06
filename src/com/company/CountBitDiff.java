package com.company;

/**
 * 那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 
 * @author XIAO
 *
 */
public class CountBitDiff {
	public int countBitDiff(int m, int n) {
		int diff = m ^ n;
		int count = 0;
		while (diff != 0) {
			diff = diff & (diff - 1);
			count++;
		}
		return count;

	}

}
