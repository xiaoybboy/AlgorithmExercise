package com.company.jingdong;

import java.util.Scanner;

/**
 * 异或运算是常见的二进制运算，给出两个n位二进制数a，b。a异或b的运算依次考虑二进制的每一位，若这一位相同，那么这一位的异或结果就是0，
 * 
 * 不同就是1。 例如a=1100,b=0100。执行a异或b的运算，a的最高位是1，b的最高位是0，两个数字不同所以最高位异或结果是1；a和b次高位都是1，
 * 所以次高位异或为0；最后两位它们都是0，所以异或结果也都是0。那么a异或b的答案就是1000。
 * 现在输入两个n位二进制数，输出它们异或结果的十进制答案。上述样例中异或的二进制结果为1000，转化成十进制就是8。
 * 
 * 输入
 * 
 * 输入有三行，第一行一个数n(1<=n<=20)，接下来两行有两个n位二进制数。输入的二进制数可能有前导零。
 * 
 * 样例输入
 * 
 * 4
 * 
 * 1100
 * 
 * 0100
 * 
 * 输出
 * 
 * 输出一个数，异或结果的十进制数值，不要输出前导零。
 * 
 * @author XIAO
 *
 */
public class XOR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String str1 = sc.next();
		String str2 = sc.next();

		int[] res = new int[length];

		for (int i = 0; i < length; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				res[i] = 1;
			} else {
				res[i] = 0;
			}
		}

		int result = 0;
		// 计算十进制结果
		for (int j = 0; j < length; j++) {
			result += Math.pow(2, length - j - 1) * res[j];
		}
		System.out.println(result);

	}

}
