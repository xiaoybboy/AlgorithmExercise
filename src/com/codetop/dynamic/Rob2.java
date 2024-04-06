package com.codetop.dynamic;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
 */
public class Rob2 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 1, 1};
        rob(array);
    }

    /**
     * 分为两种情况：
     * <p>
     * 第一间偷，那么就在[0,n−2]区间上（因为此时最后一间不能偷，直接忽略）进行“打家劫舍1”的DP。
     * <p>
     * 第一间不偷，那就在[1,n−1]区间上进行“打家劫舍1”的DP。
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }

    /**
     * 抢劫1,动态规划
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int rob(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }
}
