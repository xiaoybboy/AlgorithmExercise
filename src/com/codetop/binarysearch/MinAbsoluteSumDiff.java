package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * <p>
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 */
public class MinAbsoluteSumDiff {
    //贪心：考虑是当|nums1[i] - nums2[i]|最大的时候，替换会返回最小绝对差值和吗？
    //答案是不是，因为题目要求必须替换的是num1中的元素，例如nums1[]: [1,2,3],nums2[]: [2,3,10]
    //如果去替换下标2的元素，则最后的结果反而变大了
    //所以应该是要替换改变效果最明显的，即maxDelta = diff(原来的差值)−changedDiff(替换之后的差值);
    //应该怎么找，搜索num1中的每一个元素i，查找nums1中和num2[i]最接近的左右两个数进行替换，比较即maxDelta
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int mod = (int) 1e9 + 7;
        //Clone一个nums1用于查找
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long maxDelta = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            if (diff == 0) {
                continue;
            }
            int start = -1, end = n;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (sorted[mid] <= nums2[i]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            // 检查最接近nums2[i]的左侧元素
            if (start != -1) {
                maxDelta = Math.max(maxDelta, diff - (nums2[i] - sorted[start]));
            }
            // 检查最接近nums2[i]的右侧元素
            if (end != n) {
                maxDelta = Math.max(maxDelta, diff - (sorted[end] - nums2[i]));
            }
        }
        return (int) ((sum - maxDelta) % mod);
    }
}
