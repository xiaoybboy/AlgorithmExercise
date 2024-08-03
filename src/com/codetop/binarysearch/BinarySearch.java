package com.codetop.binarysearch;

import java.util.Arrays;

public class BinarySearch {

    /**
     * 1.二分查找
     */
    public int search(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (checkBlue(nums[mid], target)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public boolean checkBlue(int x, int target) {
        return x < target;
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 0;
        long end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long cur = mid * mid;
            if (cur == x) {
                return (int) mid;
            } else if (cur < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (int) start;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     */
    public int searchInsert(int[] nums, int target) {
        int start = -1, end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (checkBlue(nums[mid], target)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    /**
     * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
     * <p>
     * 返回峰值元素的下标。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
     * 山峰左边序列单调递增，右边序列单调递减
     */
    public int peakIndexInMountainArray(int[] arr) {
        int start = -1, end = arr.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //isBlue,山峰划分在左侧蓝色区域
            //需要考虑特殊情况，即第一个元素是山峰的情况
            int prev = mid - 1 == -1 ? arr[0] - 1 : arr[mid - 1];
            if (arr[mid] > prev) { // isBlue(mid)
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    /**
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * <p>
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * <p>
     * 不能使用任何内置的库函数，如  sqrt 。
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long start = 0, end = num + 1;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return false;
    }

    /**
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     * <p>
     * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
     * <p>
     * 在arr2中找与arr[i]最相近的数，如果连最相近的数绝对值差都大于d，那么其他就更不用考虑了
     */
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0, n = arr2.length;
        for (int x : arr1) {
            int index = binarySearch(arr2, x);
            int lowerValue = index == -1 ? arr2[0] : arr2[index];
            int higherValue = index == n - 1 ? arr2[n - 1] : arr2[index + 1];
            if (Math.abs(x - lowerValue) > d && Math.abs(x - higherValue) > d) {
                result++;
            }

        }
        return result;
    }

    //查找<=target的数下标
    public static int binarySearch(int[] arr, int target) {
        int low = -1, high = arr.length;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
     * <p>
     * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        //1.划分蓝红边界，显然蓝色letters[i]<=target,红色letters[i]>target
        //2.确定返回值。显然返回值应该是end(即右边界)
        int start = -1, end = letters.length;
        int n = letters.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //特殊情况，letters所有字符<target
        return start == n - 1 ? letters[0] : letters[end];
    }
}
