package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class NextGreaterElement2 {

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int x : nums2) {
            while (!deque.isEmpty() && deque.peek() < x) {
                ans[map.get(deque.pop())] = x;
            }
            if (map.containsKey(x)) {
                deque.push(x);
            }
        }
        while (!deque.isEmpty()) {
            ans[map.get(deque.pop())] = -1;
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        //记录nums1中的数字和下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int x : nums2) {
            while (!deque.isEmpty() && x > deque.peek()) {
                int ele = deque.pop();
                ans[map.get(ele)] = x;
            }
            //只把num1中的元素入栈，因为要查找的是num1中的下一个最大元素
            if (map.containsKey(x)) {
                deque.push(x);
            }
        }
        //不存在下一个最大元素的
        while (!deque.isEmpty()) {
            ans[map.get(deque.pop())] = -1;
        }
        return ans;
    }
}
