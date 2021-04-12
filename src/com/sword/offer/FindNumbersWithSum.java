package com.sword.offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 思路：双指针法
 * 有序数组的常用方法
 * 1.初始化：指针i指向数组首， 指针j指向数组尾部
 * 2. 如果arr[i] + arr[j] == sum , 说明是可能解
 * 3. 否则如果arr[i] + arr[j] > sum, 说明和太大，所以--j
 * 4. 否则如果arr[i] + arr[j] < sum, 说明和太小，所以++i
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = array.length - 1;

        int product = Integer.MAX_VALUE;

        while (i < j) {
            int ijSum = array[i] + array[j];
            if (ijSum > sum) {
                j--;
            } else if (ijSum < sum) {
                i++;
            } else {
                if (i * j < product) {
                    result.clear();
                    result.add(array[i]);
                    result.add(array[j]);
                    product = i * j;
                }
                i++;
            }
        }
        return result;
    }
}
