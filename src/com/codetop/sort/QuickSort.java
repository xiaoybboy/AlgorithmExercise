package com.codetop.sort;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 排序过程
     *
     * @param array
     * @param low
     * @param high
     */
    public void sort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            sort(array, low, index - 1);
            sort(array, index + 1, high);
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
    public int partition(int[] array, int low, int high) {
        int pivot = low;
        int index = low + 1;
        for (int i = index; i <= high; i++) {
            //找到一个比pivot小的元素，交换到前面
            //保证前面都是比pivot小的元素，后面都是比pivot大的元素
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        //index-1是最后一个小于pivot的元素的位置
        swap(array, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
