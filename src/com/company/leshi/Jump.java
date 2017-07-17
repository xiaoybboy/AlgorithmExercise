package com.company.leshi;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 小B对脑筋急转弯问题很有兴趣，她觉得这种问题的挑战能够反映一个人的应急反应能力。她正在开发一个智力测试的游戏，游戏的主角是一个蚂蚱。
 * 蚂蚱最初位于0点处，可以在直线上向正向或反向两个方向跳跃。比较特别的是，蚂蚱每次跳跃的距离比前一次跳跃多一个单位，第一次跳跃的距离为一个单位。
 * 
 * 小B的问题是，如果让蚂蚱跳跃到x处，需要经过多少次跳跃，你能解决这个问题吗？
 * 
 * 
 * 输入 输入中有多组测试数据。每组测试数据为单独的一行，包含一个整数x（-10^9 =＜x =＜10^9）。
 * 
 * 样例输入
 * 
 * 2
 * 
 * 6
 * 
 * 0
 * 
 * 输出 对每组测试数据，在单独的行中输出蚂蚱最少需要跳跃的次数。
 * 
 * 样例输出
 * 
 * 3
 * 
 * 3
 * 
 * 0
 * 
 * @author XIAO
 *
 */
public class Jump {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
			if (x < 0)
				x = -x;
			int total = 0;// 从0开始，每次移动j步(j=1,2,3,4...)正向移动，距离X最近的右边的位置需要的步数
			int count = 0;
			int j = 1;
			for (; total < x; j++) {
				total += j;
				count++;
			}
			// total一定是大于x的
			if (total == x) {
				System.out.println(count);
			} else if ((total - x) % 2 == 0) {
				// total>x，所以前面的count步需要有往回走的情况，而往回走相当于多走了2倍的total-x的距离。因为每次走的步子j是连续的，所以一定可以调整前面走的方向，最后正好走到x处。
				System.out.println(count);
			} else {
				while ((total - x) % 2 != 0) {// 需要多走一个奇数步j来构成偶数,此循环最多执行两次，也可直接用if
												// else只要total-x是偶数即可
					total += j;
					j++;
					count++;
				}
				System.out.println(count);
			}
		}
		scanner.close();
	}
}
