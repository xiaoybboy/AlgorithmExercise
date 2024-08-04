package com.codetop.binarysearch;

/**
 * 给你两个 非递增 的整数数组 nums1 和 nums2 ，数组下标均 从 0 开始 计数。
 * <p>
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​
 * <p>
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 * <p>
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 */
public class MaxDistance {

    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int maxInstance = 0;
        for (int i = 0; i < n1; i++) {
            int start = i - 1, end = n2;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums2[mid] >= nums1[i]) {//isBlue
                    start = mid;
                } else {
                    end = mid;
                }
            }
            maxInstance = Math.max(maxInstance, start - i);
        }
        return maxInstance;
    }
}
