package com.codetop.backtrack;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 */
public class CanPartition {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % k != 0) {
            return false;
        }
        //每个桶中应该的和
        int target = sum / k;
        int[] buckets = new int[k];
        return backTrack(nums, 0, target, buckets);
    }

    private boolean backTrack(int[] nums, int index, int target, int[] buckets) {
        if (index == nums.length) {
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != target) {
                    return false;
                }
            }
            return true;
        }
        //球视角，把球放到k个桶中
        int k = buckets.length;
        for (int i = 0; i < k; i++) {
            //剪枝
            if (buckets[i] + nums[index] > target) {
                continue;
            }
            if (i > 0 && buckets[i] == buckets[i - 1]) {
                continue;
            }
            //做出选择
            buckets[i] += nums[index];
            if (backTrack(nums, index + 1, target, buckets)) {
                return true;
            }
            buckets[i] -= nums[index];
        }
        return false;
    }
}
