package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * 子数组 是数组中一个连续且可能为空的元素序列。
 */
public class LongestEqualSubarray {

    /**
     * 首先对于一个滑动窗口 [left, right]，我们要让它最多删除 k 个元素后成为一个等值子数组，就要选择窗口中的出现次数最多的元素作为等值子数组的元素，
     * 即我们记出现次数最多的元素出现了 cnt 次，那么 要删除的元素个数就是窗口内除了这 cnt 个元素以外的元素，即 right - left + 1 - cnt个。
     * 最终等值子数组的长度就是 cnt。
     */
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, Integer> counts = new HashMap<>(); // 统计元素个数
        int left = 0;       // 左指针
        int currMaxCnt = 0; // 窗口[left, right]内最大元素个数
        int res = 0;        // 结果
        for (int right = 0; right < n; right++) { // 右指针
            counts.put(nums.get(right), counts.getOrDefault(nums.get(right), 0) + 1);  // 将右指针指向的元素加入窗口
            currMaxCnt = Math.max(currMaxCnt, counts.get(nums.get(right)));  // 更新最大值
            while (right - left + 1 > k + currMaxCnt) {   // 右移左指针直到满足条件
                counts.put(nums.get(left), counts.getOrDefault(nums.get(left), 0) - 1);   // 左指针指向的元素移出窗口
                currMaxCnt = Math.max(currMaxCnt, counts.get(nums.get(left)));   // 更新最大值
                left++;
            }
            res = Math.max(res, currMaxCnt); // 更新结果
        }
        return res;
    }
}
