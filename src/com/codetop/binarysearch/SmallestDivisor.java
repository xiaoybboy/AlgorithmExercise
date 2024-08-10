package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * <p>
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * <p>
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 */
public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        //除数最小为1，最大为maxValue。当除数>maxValue时结果和maxValue一样
        int start = 0, end = maxValue + 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (check(nums, mid, threshold)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private boolean check(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int x : nums) {
            sum += x % divisor == 0 ? x / divisor : x / divisor + 1;
        }
        //蓝色，求和结果>threshold
        return sum > threshold;
    }
}
