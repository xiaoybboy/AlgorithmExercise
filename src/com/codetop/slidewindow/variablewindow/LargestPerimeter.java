package com.codetop.slidewindow.variablewindow;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 */
public class LargestPerimeter {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }
}
