package com.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 8, 4, 0, 2, 6, 7};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(i);
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i > 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}
