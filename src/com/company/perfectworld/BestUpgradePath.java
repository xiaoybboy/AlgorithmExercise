package com.company.perfectworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 游戏网站提供若干升级补丁，每个补丁大小不一，玩家要升级到最新版，如何选择下载哪些补丁下载量最小。
 * 
 * 
 * 输入
 * 
 * 第一行输入 第一个数为用户版本 第二个数为最新版本，空格分开 接着输入N行补丁数据 第一个数补丁开始版本 第二个数为补丁结束版本
 * 第三个数为补丁大小，空格分开
 * 
 * 样例输入
 * 
 * 1000 1050
 * 
 * 1000 1020 50
 * 
 * 1000 1030 70
 * 
 * 1020 1030 15
 * 
 * 1020 1040 30
 * 
 * 1030 1050 40
 * 
 * 1040 1050 20
 * 
 * 输出 对于每个测试实例，输出一个升级路径以及最后实际升级的大小
 * 
 * 样例输出
 * 
 * 1000->1020->1040->1050(100)
 * 
 * @author XIAO
 *
 */
public class BestUpgradePath {
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<Integer, Integer> ma = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(n, 0);
		while (sc.hasNext()) {
			int a = sc.nextInt();// 1000
			int b = sc.nextInt();// 1050
			int c = sc.nextInt();// 70
			Integer in = map.get(b);
			int t = map.get(a) + c;
			if (in == null || in > t) {
				map.put(b, t);
				ma.put(b, a);
			}
		}
		Integer in = m;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while ((in = ma.get(in)) != null) {
			al.add(in);
		}
		for (int i = al.size() - 1; i >= 0; i--) {
			System.out.print(al.get(i));
			System.out.print("->");
		}
		System.out.print(m);
		System.out.println("(" + map.get(m) + ")");
		sc.close();
	}
}
