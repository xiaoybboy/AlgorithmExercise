package com.offer2;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 * @author XIAO
 *
 */

public class StrToInt {
	public int StrToIntSolution(String str) {
		if (str.equals("") || str.length() == 0) {
			return 0;
		}
		char[] sequence = str.toCharArray();
		int huhao = 0;// 默认是正数,从0的位置开始转换
		if (sequence[0] == '-') {
			huhao = 1;// 负数，从数组1的位置开始转换
		}
		int sum = 0;
		for (int i = huhao; i < sequence.length; i++) {
			if (sequence[i] == '+') {
				continue;
			}
			if (sequence[i] < 48 || sequence[i] > 57)
				return 0;
			sum = sum * 10 + sequence[i] - 48;
		}
		return huhao == 0 ? sum : sum * -1;
	}
}
