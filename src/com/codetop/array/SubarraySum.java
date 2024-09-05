package com.codetop.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(sum[i] - k)) {
                count += map.get(sum[i] - k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return count;
    }

    /**
     * 假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。那么对于任意的两个下标i和j（i < j），
     * 如果prefixSum[j] - prefixSum[i] = k，即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。
     * <p>
     * 通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。
     * 在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，
     * 如果存在，说明从某个位置到当前位置的连续子数组的和为k，我们将对应的次数累加到结果中。
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);//当只包含一个元素的时候，为一种情况
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
