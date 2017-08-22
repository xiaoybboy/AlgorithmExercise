package com.baseAlgorithm.sort;

/**
 * 插入排序
 *
 * @author XIAO
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {1, 5, 9, 3, 10, 7, 20, 8};
        insertSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];// 保存array[i]的值

            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;//在小于key的元素的前面的一个位置插入key
        }
    }
}
