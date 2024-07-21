package com.codetop.slidewindow.fixwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和两个正整数 m 和 k 。
 * 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
 * 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
 * 子数组指的是一个数组中一段连续 非空 的元素序列
 */
public class MaxSum {

    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int n = nums.size();
        for (int i = 0; i < k; i++) {
            int num = nums.get(i);
            sum += num;
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        long maximumSum = counts.size() >= m ? sum : 0;
        for (int i = k; i < n; i++) {
            int prevNum = nums.get(i - k), currNum = nums.get(i);
            sum -= prevNum;
            sum += currNum;
            counts.put(prevNum, counts.get(prevNum) - 1);
            if (counts.get(prevNum) == 0) {
                counts.remove(prevNum);
            }
            counts.put(currNum, counts.getOrDefault(currNum, 0) + 1);
            if (counts.size() >= m) {
                maximumSum = Math.max(maximumSum, sum);
            }
        }
        return maximumSum;
    }
}
