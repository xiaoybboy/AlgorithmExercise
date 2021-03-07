package com.baseAlgorithm.sort;

/**
 * 选择排序
 *
 * @author XIAO
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 45, 65, 33, 12 };
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
        String s = "123";
        System.out.println(s.substring(0, 2));
    }

    public static void selectSort(int[] array) {
        int n = array.length;
        if (array == null || n == 0) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            // mix用来保存数组中最小元素的索引值
            int midx = i; // 选择当前的数组元素作为最小值，遍历到最后，找到最小的数组元素的索引，和当前位置交换
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[midx]) {
                    midx = j;
                }
            }
            // 每趟最多交换一次
            if (midx != i) // 如果mix不等于当前的i,让最小值的和当前位置的值交换{
                swap(array, midx, i);
            }
        }

    /**
     * 交换数组元素
     *
     * @param array
     * @param mix
     * @param i
     */
    private static void swap(int[] array, int mix, int i) {
        int temp = array[mix];
        array[mix] = array[i];
        array[i] = temp;
    }
}
