package com.offer2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 思路：真的思路太强。
 * 
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。  排序规则如下：  若ab >
 * ba 则 a > b，  若ab < ba 则 a < b， 若ab = ba 则 a = b；  解释说明： * 比如 "3" <"31" 但是
 * "331" > "313"，所以要将二者拼接起来进行比较
 * 
 * @author XIAO
 *
 */
public class MinNumberArray {

	public String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		int length = numbers.length;
		String[] strings = new String[length];
		// 把整型数转换成字符串
		for (int i = 0; i < strings.length; i++) {
			strings[i] = String.valueOf(numbers[i]);
		}
		// 对字符串数组进行排序
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder builder = new StringBuilder();
		//把排序好的字符串拼接在一起
		for (int i = 0; i < strings.length; i++) {
			builder.append(strings[i]);
		}

		return builder.toString();
	}
}
