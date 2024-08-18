package com.codetop.slidewindow.fixwindow;

/**
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 */
public class MinSwaps {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        minSwaps(nums);
    }

    public static int minSwaps(int[] nums) {
        //1.计算1的数量
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                k++;
            }
        }
        //2.窗口大小为k，计算窗口内最多数量的1
        int curSum = 0;
        int maxSum = 0;
        for (int j = 0; j < 2 * n; j++) {
            if (j < k) {
                curSum += nums[j];
            } else {
                curSum = curSum + nums[j % n] - nums[(j - k) % n];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        //最少交换次数
        return k - maxSum;
    }
}
