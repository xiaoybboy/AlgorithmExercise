package com.sword.offer;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class findKthNumInArray {

    public int findKth(int[] a, int n, int K) {
        return findK(a, 0, n-1, K);
    }

    /**
     * 分割
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            //这里和快排不一样,倒序，要找第K大的数
            while (low < high && array[high] <= pivot) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] >= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = pivot;
        return high;
    }

    public int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);
            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }
}
