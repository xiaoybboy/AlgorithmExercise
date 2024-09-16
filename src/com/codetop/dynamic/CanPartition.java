package com.codetop.dynamic;

/**
 * 给你一个 只包含正整数的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {

    /**
     * 给定一个只包含正整数的非空数组 nums[0]，判断是否可以从数组中选出一些数字，使得这些数字的和等于整个数组的元素和的一半。
     * <p>
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        //如果和为奇数，则不可能存在
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        //如果最大值大于和的一半，则也不可能存在
        if (maxNum > target) {
            return false;
        }
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[n][target + 1];
        //默认target == 0都是可以填充的
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                //默认等于不取i位置的结果
                dp[i][j] = dp[i - 1][j];
                //修正，dp[i - 1][j] 为不取i位置的物品；dp[i - 1][j - nums[i]]为取i位置的物品
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            //这里可以剪枝
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[n - 1][target];
    }


}
