package com.codetop;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * partition操作
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = pivot;
        return high;
    }

    /**
     * 排序过程
     *
     * @param array
     * @param low
     * @param high
     */
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            sort(array, low, index - 1);
            sort(array, index + 1, high);
        }
    }
}
