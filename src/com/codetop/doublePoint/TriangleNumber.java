package com.codetop.doublePoint;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class TriangleNumber {

    /**
     * 三角形有效条件：a+b>c
     */
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        //从后面向前枚举
        for (int i = nums.length - 1; i > 1; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
