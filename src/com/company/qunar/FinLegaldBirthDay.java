package com.company.qunar;

import java.util.Scanner;

/**
 * 18位身份证的编码规则是： 前1、2位数字表示：所在省（直辖市、自治区）的代码 第3、4位数字表示：所在地级市（自治州）的代码
 * 第5、6位数字表示：所在区（县、自治县、县级市）的代码； 第7—14位数字表示：出生年、月、日； 第15、16位数字表示：所在地的派出所的代码；
 * 第17位数字表示性别：奇数表示男性，偶数表示女性； 第18位数字是校检码，用来检验身份证的正确性。
 * 现在要求给定任意身份证号，返回该身份证的出生日期信息，如果身份证格式不对，输出“ERROR”。
 * 
 * 输入
 * 
 * 输入数据有多行，每行为一个身份证
 * 
 * 样例输入
 * 
 * 502104198803308324
 * 
 * 5021041988033084
 * 
 * 输出
 * 
 * 输出生日部分
 * 
 * 样例输出
 * 
 * 19880330
 * 
 * ERROR
 * 
 * @author XIAO
 *
 */
public class FinLegaldBirthDay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.length() == 18) {
				String result = s.substring(6, 14);
				System.out.println(result);
			} else {
				System.out.println("ERROR");
			}

		}
	}
}
