package com.exercise1;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 
 * 例如，当字符串为We AreHappy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * 思路：先计算原字符串中空格的数量，然后计算新字符串的长度，这里的新不是新分配空间，
 * 
 * 而是在原来的基础上，加上%20占的空间。然后从后往前替换，为什么从后往前呢，因为如果从前往后替换，
 * 
 * 每次遇到空格，后面的字符都要往后移动，这效率就低了。从后往前就没这个问题，因为后面的都是空闲空间，数据不会丢失。
 * 
 * @author XIAO
 *
 */
public class ReplaceStringSpace {
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("hello wor ld");
		System.out.println(new ReplaceStringSpace().replaceSpaceSolution(buffer));
	}

	public String replaceSpaceSolution(StringBuffer str) {
		int spacenum = 0;// spacenum为计算空格数
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				spacenum++;
		}
		int indexold = str.length() - 1; // indexold为为替换前的 str 最大下标
		int newlength = str.length() + spacenum * 2;// 计算空格转换成%20之后的str长度
		int indexnew = newlength - 1;// indexold为为把空格替换为%20后的str 最大下标
		str.setLength(newlength);// 使str的长度扩大到转换成%20之后的长度,防止下标越界

		for (; indexold >= 0; indexold--) {
			if (str.charAt(indexold) == ' ') { //
				str.setCharAt(indexnew, '0');
				indexnew--;
				str.setCharAt(indexnew, '2');
				indexnew--;
				str.setCharAt(indexnew, '%');
				indexnew--;
			} else {
				str.setCharAt(indexnew, str.charAt(indexold));
				indexnew--;
			}
		}
		return str.toString();
	}
}
