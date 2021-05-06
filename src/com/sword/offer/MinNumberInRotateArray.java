package com.sword.offer;

/**
 * 求旋转数组中最小值
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 分析：二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
 * 处于递增：low上移
 * 处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
 * 其余情况：low++缩小范围
 * 特殊情况  10111
 */
public class MinNumberInRotateArray {

    /**
     * 二分法
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while (low < high) {
            if (array[low] < array[high]) {
                return array[low];
            }
            mid = low + (high - low) / 2;
            if (array[mid] > array[low]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }
}
