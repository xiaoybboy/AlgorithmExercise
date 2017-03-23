package com.test2;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 
 * 思路：从递增数组中两个何=和为s的数得到启示，我们也可以设置两个指针，一个指向当前序列的最小的数，一个指向当前序列最大的数。
 * 1）设置两个指针，一个为small指向当前正数序列中最小的数，一个为big指向当前正数序列中最大的数；
 * 2）若是当前的正数序列之和大于S，那么缩小序列范围，让small指针不停往前走，知道等于S停止；
 * 3）若是当前的正数序列之和小于S，那么扩大序列范围，让big指针不停往前走，直到和为S停止；
 * 注意点：设置mid变量，赋值为(1+s)/2，因为何为s的序列至少包括两个数，所以small要小于s的一半；
 * 
 * @author XIAO
 *
 */
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> FindContinuousSequenceSum(int sum) {
		int start = 1, end = 2;
		int mid = (sum + 1) / 2;
		int total = start + end;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while (start < mid) {
			if (total == sum) {
				res.add(helper(start, end));
				total -= start;
				start++;
				end++;
				total += end;
			} else if (total < sum) {
				end++;
				total += end;
			} else {
				total -= start;
				start++;
			}

		}
		return res;
	}

	public ArrayList<Integer> helper(int start, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		return list;
	}
}
