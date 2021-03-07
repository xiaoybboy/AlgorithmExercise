package com.sort;

/**
 * 第二种快速排序实现
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {1, 4, 7, 8, 10, 6, 3, 2};
        sort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
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
