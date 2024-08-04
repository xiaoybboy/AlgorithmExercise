package com.codetop.doublePoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int[] intersect = new int[Math.min(n1, n2)];
        List<Integer> list = new ArrayList<>();
        int idx1 = 0, idx2 = 0, interIdx = 0;
        while (idx1 < n1 && idx2 < n2) {
            if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                list.add(nums1[idx1]);
                intersect[interIdx] = nums1[idx1];
                idx1++;
                idx2++;
            }
        }
        //需要把多余的
        return Arrays.copyOfRange(intersect, 0, interIdx);
    }
}
