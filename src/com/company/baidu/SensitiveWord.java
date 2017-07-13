package com.company.baidu;

import java.util.Scanner;

/**
 * 大部分论坛、网站等，为了方便管理，都进行了关于敏感词的设定。
 * 在多数网站，敏感词一般是指带有敏感政治倾向、暴力倾向、不健康色彩的词或不文明语，也有一些网站根据自身实际情况，设定一些只适用于本网站的特殊敏感词。比如，当你发贴的时候带有某些事先设定的词时，这个贴是不能发出的。或者这个词被自动替换为星号
 * (*)，或者说是被和谐掉了。请注意敏感词只有小写字母，文本如果中的大写字母当做小写字母处理，出现敏感单词，即使作为子串出现也要被和谐，多个子串重叠他们都要被和谐。
 * 
 * 例如当敏感词是gre，eat 是 Your English is Great. 将被和谐成 Your English is *****.
 * 
 * 请编程，输入给定的文本和关键字，将所有被和谐的部分都打上星号 (*)
 * 
 * @author XIAO
 *
 */
public class SensitiveWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		String[] sensitiveWords = new String[num];
		for (int i = 0; i < sensitiveWords.length; i++) {
			sensitiveWords[i] = sc.nextLine().toLowerCase();
		}

		String sentence = sc.nextLine();
		String[] words = sentence.split(" ");
		StringBuffer buffer = new StringBuffer();
		for (int j = 0; j < words.length; j++) {
			if (contain(sensitiveWords, words[j].toLowerCase())) {
				StringBuffer temp = new StringBuffer();
				for (int k = 0; k < words[j].length(); k++) {
					temp.append('*');
				}
				buffer.append(temp);
			} else {
				buffer.append(words[j]);
			}
			if (j != words.length - 1) {
				buffer.append(" ");
			}
		}
		System.out.println(buffer.toString());

	}

	// 判断数组中是否包含某个元素
	public static boolean contain(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}

}
