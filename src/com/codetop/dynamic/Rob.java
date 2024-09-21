package com.codetop.dynamic;

import com.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {

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

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     */
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int money = root.val;
        //如果抢当前节点，那只能抢左右子树的左右节点
        if (root.left != null) {
            money += rob3(root.left.left) + rob3(root.left.right);
        }
        if (root.right != null) {
            money += rob3(root.right.left) + rob3(root.right.right);
        }
        //如果不抢当前节点，可以抢左节点或者右节点
        int rest = Math.max(money, rob3(root.left) + rob3(root.right));
        memo.put(root, rest);
        return rest;
    }
}
