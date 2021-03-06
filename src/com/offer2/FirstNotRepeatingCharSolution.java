package com.offer2;

import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 
 * 思路：暴力求解
 * 
 * @author XIAO
 *
 */
public class FirstNotRepeatingCharSolution {
	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		// 用一个map记录每个字符出现的次数
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				int times = map.get(c);
				times += 1;
				map.put(c, times);
			} else {
				map.put(c, 1);
			}
		}
		// 出现一次的字符 首次出现的索引
		for (int i = 0; i < str.length(); i++) {
			char c2 = str.charAt(i);
			if (map.get(c2) == 1) {
				return i;
			}
		}
		return -1;
	}
}
