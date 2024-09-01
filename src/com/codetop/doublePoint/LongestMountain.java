package com.codetop.doublePoint;

/**
 * 把符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在下标 i（0 < i < arr.length - 1），满足
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。
 */
public class LongestMountain {

    //中心扩散
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int ans = 0;
        //枚举山峰
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i - 1, right = i + 1;
            //如果不是左右的最高点，直接结束，进入下一个循环
            if (arr[left] >= arr[i] || arr[right] >= arr[i]) {
                continue;
            }
            //左山脚
            while (left >= 0 && arr[left] < arr[left + 1]) {
                left--;
            }
            //右山脚
            while (right < arr.length && arr[right] < arr[right - 1]) {
                right++;
            }
            ans = Math.max(ans, right - left - 1);
        }
        return ans;
    }
}
