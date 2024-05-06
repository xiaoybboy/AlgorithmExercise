package com.codetop.array;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 */
public class MergeTwoArray {
    /**
     * 从后往前遍历，保证num1不会被覆盖
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p >= 0 || q > 0) {
            //nums1已经遍历完成
            if (p < 0) {
                cur = nums2[q];
                q--;
            }
            //num2遍历完成
            else if (q < 0) {
                cur = nums1[p];
                p--;
            }
            //nums1>num2
            else if (nums1[p] > nums2[q]) {
                cur = nums1[p];
                p--;
            }else {
                cur = nums2[q];
                q--;
            }
            nums1[tail] = cur;
            tail--;
        }
    }
}
