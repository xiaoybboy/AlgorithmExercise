package com.codetop.binarysearch;

/**
 * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 * 返回峰值元素的下标。
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int start = -1, end = arr.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //特殊情况，0就是最大元素的情况
            int prev = mid - 1 < 0 ? arr[0] - 1 : arr[mid - 1];
            if (arr[mid] > prev) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
