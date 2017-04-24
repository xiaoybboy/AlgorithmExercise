package com.company.qunar;

import java.util.Scanner;

/**
 * 去哪儿专车举办某活动，每天积极抢单的司机将会获得额外收入。因为司机众多，抢单行为也不受控，因此需要防止某些司机刻意作弊。我们把作弊规则定义为：每天的抢单次数比当天其他所有司机抢单次数相加还要多，
 * 
 * 那么这个司机作弊司机。那么问题来了，怎么用最简单（时间复杂度O(n)、空间复杂度）最低的办法找到作弊司机。
 * 
 * 输入
 * 
 * 输入一个不为空的int型数组，其中每一个int值为司机的Id，表示拥有该Id的司机抢单一次
 * 
 * 样例输入
 * 
 * {1,2,2,4,5,2,7,2,9,2,2}
 * 
 * 输出
 * 
 * 如果存在作弊司机，则输出该作弊司机的Id，如不存在，则输出-1
 * 
 * 样例输出 2
 * 
 * 思路：抢单司机次数>总数的1/2.局部最长连续即为全局最长连续
 * 
 * @author XIAO
 *
 */
public class FindCheatDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.replace("{", "");
		str = str.replace("}", "");
		String strs[] = str.split(",");
		int num[] = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			num[i] = Integer.valueOf(strs[i].trim());
		}

		int result = num[0];
		int times = 1;
		for (int i = 1; i < num.length; i++) {
			if (times == 0) {
				result = num[i];
				times = 1;
			} else if (num[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		times = 0;
		for (int i = 0; i < num.length; i++)
			if (num[i] == result) {
				times++;
			}
		if (times * 2 > result) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

}
