package com.codetop.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
     * 注意： x 不必 是 nums 的中的元素。
     * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
     *
     * @param nums
     * @return
     */
    public int specialArray(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        //倒序排列
        Collections.sort(list, (a, b) -> b - a);
        //1.蓝红划分，蓝色x个元素>=x,红色<x
        //2.return left
        int left = -1, right = nums.length;
        int n = list.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //下标mid，共mid+1个元素，即前mid+1个元素 >= mid+1
            if (list.get(mid) >= mid + 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //3.后置处理
        if (left == -1 || (left + 1 != n && nums[left + 1] >= left + 1)) { // x 不存在 或者 大于 x 个元素 大于或者等于 x
            return -1; // 排除
        }
        return left + 1; // x数量为下标+1
    }
}
