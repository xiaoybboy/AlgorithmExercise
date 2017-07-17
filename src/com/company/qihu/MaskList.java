package com.company.qihu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 现在现在有一台机器，这台机器可以接收两种形式任务：
 * 
 * （1）任务列表，任务列表里面有N个任务，对于第i个任务，机器在Ti时间开始执行，并在1个单位时间内做完。
 * 
 * （2）临时任务，机器可以在任意时间接收一个临时任务，但任务列表里面的任务优先级要高于临时任务，也就是说当机器空闲的时候才会执行临时任务。
 * 
 * 现在机器已经接收一个任务列表。接下来会有M个临时任务，我们想知道每个临时任务何时被执行。为了简化问题我们可以认为这M个临时任务是独立无关即任务是可以同时执行的，
 * 互不影响的。
 * 
 * 输入 输入数据有多组，每组数据第一行包括两个整数N和M（1<=N, M<=10^5）。 接下来一行有N个不同数字T1,T2,T3.....TN（1<=T1
 * 接下来又M行，每行一个数字Qi（1<=Qi<=10^9），表示第i个临时任务的的接收时间。
 * 
 * 样例输入
 * 
 * 5 6
 * 
 * 1 2 3 5 6
 * 
 * 3 2 1 4 5 6
 * 
 * 输出 对于每个临时任务，输出它被执行的时间。
 * 
 * 样例输出
 * 
 * 4 4 4 4 7 7
 * 
 * 思路：http://exercise.acmcoder.com/online/online_judge_answer_pdf?ques_id=3982&konwledgeId=42
 * 
 * @author XIAO
 *
 */
public class MaskList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = null;
		while (sc.hasNext()) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			map = new TreeMap<Integer, Integer>();// 任务列表时间
			for (int k = 0; k < N; k++) {
				map.put(sc.nextInt(), 0);
			}

			int index = 0;
			int tempIndex = 0;
			for (int i = 0; i < M; i++) {
				index = sc.nextInt();// 每一个临时任务的时间
				if (!map.containsKey(index)) {// 如果临时任务的时间不在任务列表时间中，那么可以立即执行
					System.out.println(index);
				} else {
					tempIndex = index;
					while (map.containsKey(tempIndex)) {
						tempIndex++;// 寻找Map中比index大一的时间点
					}
					System.out.println(tempIndex);
				}
			}
		}
	}
}
