package com.codetop.slidewindow.fixwindow;

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 */
public class NumOfSubarrays {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0, end = k - 1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int count = sum >= threshold * k ? 1 : 0;
        for (int j = k; j < arr.length; j++) {
            sum = sum - arr[j - k] + arr[j];
            if (sum >= threshold * k) {
                count++;
            }
        }
        return count;
    }
}
