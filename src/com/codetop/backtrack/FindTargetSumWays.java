package com.codetop.backtrack;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class FindTargetSumWays {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, 0, target);
        return result;
    }

    private void backTrack(int[] nums, int index, int curSum, int target) {
        if (index == nums.length) {
            if (curSum == target) {
                result++;
            }
            return;
        }
        //树形结构考虑，因为每次的选择都是固定的，必定是当前数字的下一个数字。
        //唯一的选择，就是可以选择+或者-,所以递归的情况可以直接枚举，类似二叉树的递归过程
        //1.选择加号
        backTrack(nums, index + 1, curSum + nums[index], target);
        //2.选择减号
        backTrack(nums, index + 1, curSum - nums[index], target);
    }
}
