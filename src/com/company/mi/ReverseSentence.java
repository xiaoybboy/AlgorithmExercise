package com.company.mi;

import java.util.Scanner;

/**
 * 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao
 * mi”-> “mi xiao hello”
 * 
 * 输入 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
 * 
 * 样例输入
 * 
 * hello xiao mi
 * 
 * 输出 对于每个测试示例，要求输出句子中单词反转后形成的句子
 * 
 * 样例输出
 * 
 * mi xiao hello
 * 
 * @author XIAO
 *
 */
public class ReverseSentence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String sentence = sc.nextLine();
			String[] senArray = sentence.split(" ");
			StringBuilder builder = new StringBuilder();
			for (int i = senArray.length - 1; i >= 0; i--) {
				if (i != 0) {
					builder.append(senArray[i] + " ");
				} else {
					builder.append(senArray[i]);
				}
			}
			System.out.println(builder.toString());
		}
	}
}
