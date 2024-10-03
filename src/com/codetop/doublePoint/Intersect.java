package com.codetop.doublePoint;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        //1.排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[Math.min(n1, n2)];
        //2.双指针
        int index1 = 0, index2 = 0, ansIndex = 0;
        while (index1 < n1 && index2 < n2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                ans[ansIndex] = nums1[index1];
                index1++;
                index2++;
                ansIndex++;
            }
        }
        return Arrays.copyOfRange(ans, 0, ansIndex);
    }

    /**
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int x : nums2) {
            int count = map.getOrDefault(x, 0);
            if (count > 0) {
                res[index++] = x;
                count--;
                if (count > 0) {
                    map.put(x, count);
                } else {
                    map.remove(x);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
