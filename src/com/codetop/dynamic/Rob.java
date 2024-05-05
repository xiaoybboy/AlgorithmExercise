package com.codetop.dynamic;

public class Rob {

    /**
     * 让我们用桶排的思想预先处理输入数组。
     * 设置数组bucket[10001]用于存放范围为[1, 10000]的nums[i],bucket[nums[i]]的值为所有等于nums[i]的数的总和，这样，“打家劫舍”的模型已经完全建好~
     * 最后，用dp[i]表示“遍历到数字i时，所能获取的最大的分数”，转移方程很显然：
     * <p>
     * dp[i] = Math.max(dp[i - 2] + bucket[i], dp[i - 1]);//取数字i则加上dp[i - 2],或者不取数字i维持dp[i - 1]
     * 边界条件：
     * dp[1] = bucket[1];
     */
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] bucket = new int[maxVal + 1];
        for (int val : nums) {
            bucket[val] += val;
        }

        int[] dp = new int[maxVal + 1];
        dp[1] = bucket[1];
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 2] + bucket[i], dp[i - 1]);
        }
        return dp[maxVal];
    }

    /**
     * if k == 0 ,dp = 0
     * if k == 1,dp = nums[k];
     * dp[k] = max(dp[k-1],dp[k-2]+nums[k])
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 分为两种情况：
     * <p>
     * 第一间偷，那么就在[0,n−2]区间上（因为此时最后一间不能偷，直接忽略）进行“打家劫舍1”的DP。
     * <p>
     * 第一间不偷，那就在[1,n−1]区间上进行“打家劫舍1”的DP。
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * * <p>
     * * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
     */
    public static int rob2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob2(nums, 0, length - 2), rob2(nums, 1, length - 1));
    }

    /**
     * 抢劫1,动态规划
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int rob2(int[] nums, int start, int end) {
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
