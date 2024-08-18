package com.codetop.slidewindow.fixwindow;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的数组 nums ，数组中有 n 个整数，另给你一个整数 k 。
 * 半径为 k 的子数组平均值 是指：nums 中一个以下标 i 为 中心 且 半径 为 k 的子数组中所有元素的平均值，
 * 即下标在 i - k 和 i + k 范围（含 i - k 和 i + k）内所有元素的平均值。如果在下标 i 前或后不足 k 个元素，那么 半径为 k 的子数组平均值 是 -1 。
 * <p>
 * 构建并返回一个长度为 n 的数组 avgs ，其中 avgs[i] 是以下标 i 为中心的子数组的 半径为 k 的子数组平均值 。
 * x 个元素的 平均值 是 x 个元素相加之和除以 x ，此时使用截断式 整数除法 ，即需要去掉结果的小数部分。
 * 例如，四个元素 2、3、1 和 5 的平均值是 (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75，截断后得到 2 。
 */
public class GetAverages {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1);
        int window = 2 * k + 1;
        if (window > n) {
            return avgs;
        }
        int start = k, end = n - k - 1;
        long sum = 0;
        for (int i = 0; i < window; i++) {
            sum += nums[i];
        }
        avgs[start] = (int) (sum / window);
        for (int i = start + 1; i <= end; i++) {
            sum -= nums[i - k - 1];
            sum += nums[i + k];
            avgs[i] = (int) (sum / window);
        }
        return avgs;
    }
}
