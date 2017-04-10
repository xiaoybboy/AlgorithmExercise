package com.company.netease;

import java.util.Scanner;

/**
 * 常规的表达式求值，我们都会根据计算的优先级来计算。比如/*的优先级就高于+-。但是小易所生活的世界的表达式规则很简单，
 * 从左往右依次计算即可，而且小易所在的世界没有除法，意味着表达式中没有/，只有(+,-和*)。现在给出一个表达式，
 * 需要你帮忙计算出小易所在的世界这个表达式的值为多少
 * 
 * 输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9. 保证表达式都是合法的，排列规则如样例所示。
 * 
 * @author XIAO
 *
 */
public class StrangeExpressionEvaluation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] ex;
		String a = scanner.nextLine();
		ex = a.toCharArray();
		int ans = ex[0] - '0';
		for (int i = 1; i < ex.length; i += 2) {
			if (ex[i] == '*') {
				ans *= (ex[i + 1] - '0');
			} else if (ex[i] == '+') {
				ans += (ex[i + 1] - '0');
			} else {
				ans -= (ex[i + 1] - '0');
			}
		}
		System.out.println(ans);
		scanner.close();
	}
}
