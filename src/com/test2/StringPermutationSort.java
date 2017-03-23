package com.test2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 
 * 思路：先求解字符串的全排列，然后对这些全排列进行排序。
 * 
 * @author XIAO
 *
 */
public class StringPermutationSort {

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<>();// 保存全排列的结果
		if (str != null && str.length() > 0) {// 如果str不为空           
			Permutation(str.toCharArray(), 0, result);// 获取字符串的全排列  
		}
		Collections.sort(result);// 对全排列的字符串进行排序
		return result;
	}

	/**
	 * i 表示起始位置，从i这个位置开始向后寻找下面字符的全排列
	 * 
	 * @param charArray
	 * @param i
	 * @param result
	 */
	private void Permutation(char[] charArray, int i, ArrayList<String> result) {
		// 如果 i 是最后一个字符位置
		if (i == charArray.length - 1) {
			result.add(String.valueOf(charArray));// 找到一个全排序
		} else {
			for (int j = i; j <= charArray.length - 1; j++) {
				if (j != i && charArray[j] == charArray[i])// 有重复字符时，跳过
					continue;
				swap(charArray, i, j);
				Permutation(charArray, i + 1, result);
				swap(charArray, i, j);
			}
		}
	}

	// 交换字符数组s的第i个位置和第j个位置的字符
	private void swap(char[] s, int i, int j) {
		if (s[i] == s[j]) {
			;
		} else {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
		}
	}
}
