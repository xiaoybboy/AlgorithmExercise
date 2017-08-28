package com.baseAlgorithm.sort;

/**
 * 调整堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3};

        System.out.println("Before heap:");
        ArrayUtils.printArray(array);

        heapSort(array);

        System.out.println("After heap sort:");
        ArrayUtils.printArray(array);
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        buildMaxHeap(array);//构建最大堆

        for (int i = array.length - 1; i >= 1; i--) {
            ArrayUtils.exchangeElements(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    /**
     * 构建最大堆
     *
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        //从最后一个非叶子节点开始调整堆
        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 调整最大堆
     *
     * @param array
     * @param heapSize
     * @param index
     */
    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        /**
         * 获得当前位置，与左子树 和 右子树的最大值
         */
        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        /**
         *如果最大值不等于当前位置，交换两者位置。以largest为当前位置递归调用，调整最大堆性质
         */
        if (index != largest) {
            ArrayUtils.exchangeElements(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }
}
