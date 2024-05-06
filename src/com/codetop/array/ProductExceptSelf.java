package com.codetop.array;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];

        int[] ans = new int[length];
        if (nums.length == 0) {
            return ans;
        }
        //左侧
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //右侧
        right[length - 1] = 1;
        for (int j = length - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
