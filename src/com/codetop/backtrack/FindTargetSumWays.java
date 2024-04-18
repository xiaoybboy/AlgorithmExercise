package com.codetop.backtrack;

public class FindTargetSumWays {

    /**
     * 给你一个非负整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     */
    int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, 0, target);
        return result;
    }

    private void backTrack(int[] nums, int index, int sum, int target) {
        if (index == nums.length - 1) {
            if (sum == target) {
                result++;
            }
            return;
        }
        backTrack(nums, index + 1, sum + nums[index + 1], target);
        backTrack(nums, index + 1, sum - nums[index + 1], target);
    }
}
