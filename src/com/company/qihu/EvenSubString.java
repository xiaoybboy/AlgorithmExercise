package com.company.qihu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 一个字符串S是偶串当且仅当S中的每一个字符都出现了偶数次。如字符串”aabccb”是一个偶串，因为字符a,b,c都出现了两次。而字符串”abbcc”不是偶串，
 * 因为字符a出现了一次。
 * 现在给出一个长度为n的字符串T=t1,t2,t3,…,tn。字符串的子串为其中任意连续一段。T长度为1的子串有n个，长度为2的子串有n-1个，以此类推，
 * T一共有n(n+1)/2个子串。给定T，你能算出它有多少个子串是偶串吗？
 * 
 * 输入 输入一个字符串T，T中只有小写字母。T的长度不超过100000。
 * 
 * 样例输入
 * 
 * abbc
 * 
 * 输出 输出一个数，T的所有子串中偶串的个数。
 * 
 * 样例输出
 * 
 * 1
 * 
 * @author XIAO
 *
 */
public class EvenSubString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();

		int count = 0;
		for (int i = 0; i < t.length() - 1; i++) {
			for (int j = i + 1; j <= t.length(); j++) {
				String temp = t.substring(i, j);
				if (temp.length() % 2 == 1) {// 奇数个字符组成的子串一定不是偶串
					continue;
				} else {
					if (isEvenString(temp)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static boolean isEvenString(String temp) {
		boolean flag = true;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < temp.length(); i++) {
			char c = temp.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
