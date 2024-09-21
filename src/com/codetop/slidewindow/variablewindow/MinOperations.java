package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class MinOperations {

    public static void main(String[] args) {
        int[] nums = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        minOperations(nums, 134365);
    }

    /**
     * 问题转换为求中间连续子数组的最大长度，使得子数组的和为 x=sum(nums)−x。
     */
    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        int start = 0, n = nums.length;
        int curSum = 0;
        int maxLen = -1;
        for (int end = 0; end < n; end++) {
            curSum += nums[end];
            while (curSum > target && start <= end) {
                curSum -= nums[start];
                start++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}
