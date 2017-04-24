package com.company.qunar;

import java.util.ArrayList;

/**
 * 
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified. You should
 * pack your words in a greedy approach;
 * 
 * that is, pack as many words as you can in each line. Pad extra spaces
 * 
 * 输入 第一行：一段完整的英文句子（可以理解为一个字符串数组）
 * 
 * 第二行：一个整数，每行最大字符数
 * 
 * 样例输入
 * 
 * Our world is but a small part of the cosmos.
 * 
 * 9
 * 
 * 输出
 * 
 * 输出按每行最大字符数完整对齐的结果
 * 
 * 算法思想： 1. 首先需要从数组中挑出几个可以组成一个String的元素（这有两种情况，是不是最后一行）
 * 
 * 2.如果是最后一行，比较容易，将短缺的长度用空格补充即可
 * 
 * 3. 如果不是最后一行，又有几种情况，
 * 
 * 3.1. 一个单词组成的行，只需要填充后面
 * 
 * 3.2多个单词组成，但是短缺的长度可以均匀填充
 * 
 * 3.3 多个单词组成，但是短缺的长度不可以均匀填充（3.2和3.3一并处理）
 * 
 * 4 递归处理数组剩下的部分
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int wordsCount = words.length;
		ArrayList<String> result = new ArrayList<String>();
		int curLen = 0;
		int lastI = 0;
		for (int i = 0; i <= wordsCount; i++) {
			// 如果是最后一个单词 或 现有长度加上下一个单词和每个单词至少空一个格的长度和大于 L，
			// 就不加下一个单词了，将现有单词组合成string
			if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
				StringBuffer buf = new StringBuffer();
				// 计算需要多少个空格
				int spaceCount = L - curLen;
				// 计算要把空格分成几份，也就是这一行的单词个数-1
				int spaceSlots = i - lastI - 1;
				if (spaceSlots == 0 || i == wordsCount) {
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						if (j != i - 1)
							appendSpace(buf, 1);
					}
					appendSpace(buf, L - buf.length());
				} else {
					// 两个单词之间要填多少个空格
					int spaceEach = spaceCount / spaceSlots;
					// 剩余的空格的数量
					int spaceExtra = spaceCount % spaceSlots;
					for (int j = lastI; j < i; j++) {
						buf.append(words[j]);
						// j 不是这一行的最后一个数
						if (j != i - 1)
							// If the number of spaces on a line do not divide
							// evenly between words,
							// the empty slots on the left will be assigned more
							// spaces than the
							// slots on the right
							appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
					}
				}
				result.add(buf.toString());
				lastI = i; // 上一行遍历到的那个单词的下标（注意此单词还未添加到result中）
				curLen = 0;
			}
			if (i < wordsCount)
				curLen += words[i].length();
		}
		return result;
	}

	private void appendSpace(StringBuffer sb, int count) {
		for (int i = 0; i < count; i++)
			sb.append(' ');
	}
}
