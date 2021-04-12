package com.offer2;

import java.util.Arrays;

/**
 * 统计一个数字在升序数组中出现的次数。
 * <p>
 * 就是先二叉搜索找一下这个元素的位置，然后再开始遍历搜索一下。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        int index = Arrays.binarySearch(array, k);
        if (index < 0) {
            return 0;
        }
        int cnt = 1;
        for (int i = index + 1; i < array.length && array[i] == k; i++)
            cnt++;
        for (int i = index - 1; i >= 0 && array[i] == k; i--)
            cnt++;
        return cnt;
    }


    /**
     * 二分查找代码
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    // Like public version, but without range checks.
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
