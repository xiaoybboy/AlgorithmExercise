package com.codetop.doublePoint;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0, n = nums.length;
        //固定最后一个元素的好处时，当找到满足a+b>c的组合时，能立即找出所有本次满足的数量
        for (int i = n - 1; i >= 0; i++) {
            //双指针，一个指向第一个元素，一个指向最后一个元素的前一个元素
            int left = 0, right = i - 1;
            while (left < right) {
                //组成三角形的条件，a+b>c
                if (nums[left] + nums[right] > nums[i]) {
                    //从left-right的所有位置，必然满足nums[left] + nums[right] > nums[i]
                    //left指针移动到right
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
