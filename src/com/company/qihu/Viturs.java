package com.company.qihu;

import java.util.Scanner;

/**
 * 小B最近对破解和程序攻击产生了兴趣，她迷上了病毒，然后可怕的事情就发生了。不知道什么原因，可能是小B的技术水平还不够高，小B编写的病毒程序在攻击一个服务器时
 * 出现了问题。尽管成功的侵入了服务器，但并没有按照期望的方式发挥作用。
 * 
 * 小B的目的很简单:控制服务器的内存区域，试图在内存中装入从1到n之间的n个自然数，以覆盖内存区域。可能是小B对编程理解上的问题，病毒似乎没有完全成功。可能是由于
 * 保护机制的原因，内存写入只接受二进制的形式，所以十进制表达中除0和1之外的其他值都没有成功写入内存。小B希望知道，究竟有多少数成功的写入了服务器的内存！
 * 
 * 输入 输入中有多组测试数据。每组测试数据在单独的一行中，为整数n(1< =n < =10^9)。
 * 
 * 样例输入
 * 
 * 10 20
 * 
 * 输出 对每组测试数据，在单独的行中输出问题的答案。
 * 
 * 样例输出
 * 
 * 2 3
 * 
 * @author XIAO
 *
 */
public class Viturs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			int length = str.length();
			int result = 0;
			for (int i = 0; i < length; i++) {
				if (str.charAt(i) > '1') {
					result += Math.pow(2, length - i) - 1;
					break;
				} else if (str.charAt(i) == '1') {
					result += Math.pow(2, length - 1 - i);
				}
			}
			System.out.println(result);
		}
	}

}
