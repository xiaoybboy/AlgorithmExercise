package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class MinOperations {

    /**
     * 问题转换为求中间连续子数组的最大长度，使得子数组的和为 x=sum(nums)−x。
     */
    public int minOperations(int[] nums, int x) {
        int allSum = 0;
        for (int num : nums) {
            allSum += num;
        }
        int targetSum = allSum - x;
        if (targetSum < 0) {
            return -1;
        }
        int start = 0, tempSum = 0, n = nums.length;
        int maxLength = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            tempSum += nums[end];
            while (tempSum > targetSum && start < n) {
                tempSum -= nums[start];
                start++;
            }
            if (tempSum == targetSum) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        return maxLength == Integer.MIN_VALUE ? -1 : nums.length - maxLength;
    }
}
