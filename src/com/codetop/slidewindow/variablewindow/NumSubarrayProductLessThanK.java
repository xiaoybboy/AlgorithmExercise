package com.codetop.slidewindow.variablewindow;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int sum = 1, start = 0;
        int result = 0;
        for (int end = 0; end < nums.length; end++) {
            sum *= nums[end];
            while (sum >= k) {
                sum /= nums[start];
                start++;
            }
            //每次右指针位移到一个新位置，应该加上 x 种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            //共有 right - left + 1 种
            result += (end - start + 1);
        }
        return result;
    }
}
