package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，
 * 但 无法 再将两堆合并到一起。
 * <p>
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 * <p>
 * 返回每个小孩可以拿走的 最大糖果数目 。
 */
public class MaximumCandies {

    public static int maximumCandies(int[] candies, long k) {
        long max = Arrays.stream(candies).max().getAsInt();
        long start = 0, end = max + 1;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (check(candies, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int) start;
    }

    /**
     * 按照每堆target个糖果分配
     * 蓝色：可以分配
     * 红色：不可以分配
     */
    public static boolean check(int[] candies, long target, long k) {
        long total = 0;
        for (int candy : candies) {
            total += candy / target;
            if (total >= k) {
                return true;
            }
        }
        return false;
    }
}
