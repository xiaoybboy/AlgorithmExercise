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
        int start = 0, end = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Integer num = nums.get(i);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long maxSum = map.keySet().size() >= m ? sum : 0;
        for (int j = k; j < nums.size(); j++) {
            Integer num = nums.get(j);
            Integer leftNum = nums.get(j - k);
            sum = sum + num - leftNum;
            map.put(num, map.getOrDefault(num, 0) + 1);
            int newLeftNum = map.get(leftNum) - 1;
            if (newLeftNum == 0) {
                map.remove(leftNum);
            } else {
                map.put(leftNum, newLeftNum);
            }
            if (map.keySet().size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
