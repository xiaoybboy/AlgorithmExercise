package com.company.netease;

import java.util.Currency;
import java.util.Scanner;

/**
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。假设市区是一个无限大的区域，
 * 每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。小易周围有多个出租车打车点，小易赶去办公室有两种选择，
 * 一种就是走路去公司，另外一种就是走到一个出租车打车点，然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)走路将会
 * 花费walkTime时间，打车将花费taxiTime时间。小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。
 * 
 * 输入描述: 输入数据包括五行: 第一行为周围出租车打车点的个数n(1 ≤ n ≤ 50)
 * 
 * 第二行为每个出租车打车点的横坐标tX[i] (-10000 ≤tX[i] ≤ 10000)
 * 
 * 第三行为每个出租车打车点的纵坐标tY[i] (-10000 ≤ tY[i] ≤ 10000)
 * 
 * 第四行为办公室坐标gx,gy(-10000 ≤ gx,gy ≤ 10000),以空格分隔
 * 
 * 第五行为走路时间walkTime(1 ≤ walkTime ≤ 1000)和taxiTime(1 ≤ taxiTime ≤ 1000),以空格分隔
 * 
 * 输入例子:
 * 
 * 2
 * 
 * -2 -2
 * 
 * 0 -2
 * 
 * -4 -2
 * 
 * 15 3
 * 
 * @author XIAO
 *
 */
public class WalkOrTaxiToCompany {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] txi = new int[n];// 打车点横坐标
		int[] txy = new int[n];// 打车点纵坐标

		for (int i = 0; i < txi.length; i++) {
			txi[i] = sc.nextInt();
		}

		for (int j = 0; j < txy.length; j++) {
			txy[j] = sc.nextInt();
		}

		int gx = sc.nextInt();// 办公室的横坐标
		int gy = sc.nextInt();// 办公室的纵坐标

		int walkTime = sc.nextInt();// 走路时间
		int taxiTime = sc.nextInt();// 坐车时间

		// 如果走路到公司时间
		int walkToComTime = (Math.abs(gx) + Math.abs(gy)) * walkTime;

		// 走路到打车点再打车,最小时间
		int MintaxtToComTime = Integer.MAX_VALUE;
		for (int k = 0; k < n; k++) {
			int curTime = (Math.abs(txi[k]) + Math.abs(txy[k])) * walkTime
					+ (Math.abs(txi[k] - gx) + Math.abs(txy[k] - gy)) * taxiTime;
			if (curTime < MintaxtToComTime) {
				MintaxtToComTime = curTime;// 最少的打车区公司的时间
			}
		}
		// 最终的走路和打车时间的比较
		int result = Math.min(walkToComTime, MintaxtToComTime);
		System.out.println(result);
		sc.close();
	}
}
