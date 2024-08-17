package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * 在arr2中找与arr[i]最相近的数，如果连最相近的数绝对值差都大于d，那么其他就更不用考虑了
 */
public class FindTheDistanceValue {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int n = arr2.length;

        int ans = 0;
        for (int x : arr1) {
            int index = search(arr2, x);
            int lowerValue = index == -1 ? arr2[0] : arr2[index];//arr2所有数都>=x
            int higherValue = index == n - 1 ? arr2[n - 1] : arr2[index + 1];//arr2所有数<x
            //如果最接近的两个数都>d，说明肯定满足不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d
            if (Math.abs(lowerValue - x) > d && Math.abs(higherValue - x) > d) {
                ans++;
            }
        }
        return ans;
    }

    //找到最接近target的数字
    public static int search(int[] arr2, int target) {
        int start = -1, end = arr2.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr2[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
