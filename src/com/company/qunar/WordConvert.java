package com.company.qunar;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 有一个单词列表，一个初始单词和一个最终单词，初始单词需要通过单词列表逐步变换到最终单词，求变换所需的最短变换路径长度。
 * 变换规则：每次只能变动1个字母（不可交换位置，如：从abc变成cba属于变动了2个字母），每次变换只能从单词列表中选取。
 * 例如：初始单词hot，最终单词dog，单词列表[got, dot, god, dog, lot,
 * log]，最短变换路径为[hot,dot,dog]，最短变换路径长度为3。
 * 注：单词列表中包含最终单词，不包含初始单词；列表中每一项单词长度与初始单词、最终单词相同；列表中单词不重复；所有字母均为小写。
 * 
 * 输入 输入数据有三行，第一行为初始单词；第二行为最终单词；第三行为单词列表，单词和单词之间以空格分割。
 * 
 * 样例输入
 * 
 * hot
 * 
 * dog
 * 
 * got dot god dog lot log
 * 
 * 输出 最短变换路径长度。
 * 
 * 思路：最直接的想法是从start开始，对每个字母位置从'a'到'z'尝试替换。如果替换字母后的单词在字典中，将其加入路径，
 * 
 * 然后以新单词为起点进行递归调用，否则继续循环。每层递归函数终止的条件是end出现或者单词长度*26次循环完毕。
 * 
 * end出现时表示找到一个序列，对比当前最短序列做相应更新即可。
 * 
 * 处理过程中需要注意的主要有几点：
 * 
 * @author XIAO
 *
 */
public class WordConvert {
	static int minLen = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String start, end;
		String list;
		String[] words;
		while (sc.hasNext()) {
			start = sc.nextLine();
			end = sc.nextLine();
			list = sc.nextLine();
			words = list.split(" ");
			minLen = Integer.MAX_VALUE;// 最小长度
			// process
			Set<String> visited = new HashSet<>();// 一次递归，DFS时，已经变换成过哪些单词.以免造成死循环
			process(1, start, words, end, visited);
			System.out.println(minLen);
		}
		sc.close();
	}

	/**
	 * 回朔法递归求最小长度
	 * 
	 * @param len
	 * @param curr
	 * @param words
	 * @param dest
	 * @param visited
	 */
	public static void process(int len, String curr, String[] words, String dest, Set<String> visited) {
		if (dest.equals(curr)) {// 当当前curr == dest时，停止递归
			minLen = Math.min(len, minLen);
		}
		for (int i = 0; i < words.length; i++) {

			int currNum = sameLen(curr, words[i]);// 当前字符串和单词列表中的单词的不同字符的个数
			// 如果第i个字符没有变换过，才编程word[i]，否则会造成死循环
			if (!visited.contains(words[i]) && currNum == 1) {
				visited.add(words[i]);
				// 把当前字符串编程word[i],然后总的长度 +1（len+1）
				process(len + 1, words[i], words, dest, visited);// 递归求解。
				visited.remove(words[i]);
			}
		}
	}

	/**
	 * 比较两个字符串 一共有多少字符不同
	 * 
	 * @param dest
	 * @param s
	 * @return
	 */
	public static int sameLen(String dest, String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (dest.charAt(i) != s.charAt(i)) {
				num++;
			}
		}
		return num;
	}
}
