package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样。
 */
public class FindRadius {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] heaters = {2};
        findRadius(houses, heaters);
    }

    /**
     * 为了使供暖器可以覆盖所有房屋且供暖器的加热半径最小，对于每个房屋，应该选择离该房屋最近的供暖器覆盖该房屋，
     * 最近的供暖器和房屋的距离即为该房屋需要的供暖器的最小加热半径。所有房屋需要的供暖器的最小加热半径中的最大值即为可以覆盖所有房屋的最小加热半径。
     * <p>
     * 为了得到距离每个房屋最近的供暖器，可以将供暖器数组 heaters 排序，然后通过二分查找得到距离最近的供暖器。
     */
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int distance = getCloseDistance(heaters, houses[i]);
            result = Math.max(result, distance);
        }
        return result;
    }

    public static int getCloseDistance(int[] heaters, int target) {
        int n = heaters.length;
        int start = -1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (heaters[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start == -1) {
            return heaters[0] - target;
        }
        if (end == n) {
            return target - heaters[n - 1];
        }
        return Math.min(target - heaters[start], heaters[end] - target);
    }
}
