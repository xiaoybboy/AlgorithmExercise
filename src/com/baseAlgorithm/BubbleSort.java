package com.baseAlgorithm;

/**
 * 冒泡排序
 *
 * @author XIAO
 */
public class BubbleSort {
    // 冒泡排序
    public static int[] bubbleSort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            // 如果data[j]和data[j+1]反向
            for (int j = 0; j < length - 1 - i; j++)
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {67, 69, 75, 87, 89, 90, 99, 100};
        int[] sorted = BubbleSort.bubbleSort(data);
        for (int i = 0; i < sorted.length - 1; i++) {
            System.out.println(sorted[i]);
        }
    }

}
