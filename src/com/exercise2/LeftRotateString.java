package com.exercise2;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 
 * @author XIAO
 *
 */
public class LeftRotateString {
	public String LeftRotateStringSolution(String str, int n) {
		if (str == null || str.length() == 0) {
			return "";
		}
		StringBuffer buffer1 = new StringBuffer(str.substring(0, n));
		StringBuffer buffer2 = new StringBuffer(str.substring(n, str.length()));
		return buffer1.append(buffer2).toString();
	}
}
