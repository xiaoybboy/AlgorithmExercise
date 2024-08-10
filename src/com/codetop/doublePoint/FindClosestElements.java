package com.codetop.doublePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序好的数组 arr，两个整数k和x，从数组中找到最靠近x两数之差最小）的k个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 */
public class FindClosestElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findClosestElements(arr, 4, 3);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        //1.找到最接近x的下标
        int left = binarySearch(arr, x);
        //2.双指针查找元素
        int right = left + 1;
        while (k > 0) {
            //如果left,right已经到达边界处理
            if (left < 0) {
                right++;
            } else if (right >= n) {
                left--;
            } else if (arr[right] - x < x - arr[left]) {
                //如果右边数值比较接近
                right++;
            } else {
                left--;
            }
            k--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /**
     * 二分法查找离目标值最近的索引
     */
    public static int binarySearch(int[] arr, int target) {
        int low = -1, high = arr.length;
        //1.蓝红边界，蓝色<target,红色>=target
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {//isBlue
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
