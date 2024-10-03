package com.codetop.base;

import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class KthLargest {

    PriorityQueue<Integer> kPQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        kPQueue = new PriorityQueue<>(k);
        this.k = k;
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        kPQueue.offer(val);
        if (kPQueue.size() > k) {
            kPQueue.poll();
        }
        return kPQueue.peek();
    }
}
