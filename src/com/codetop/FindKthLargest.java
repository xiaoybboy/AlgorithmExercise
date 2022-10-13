package com.codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest {

    //优先队列，PriorityQueue堆中从小到大排列，其中堆顶最小，因此只需维护k个数的堆，
    //如果当前堆不满，直接添加；
    //堆满的时候，如果新读到的数小于等于堆顶，肯定不是我们要找的元素，只有新遍历到的数大于堆顶的时候，才
    //将堆顶拿出，然后放入新读到的数，进而让堆自己去调整内部结构。
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minQue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minQue.offer(nums[i]);
        }

        for (int j = k; j < nums.length; j++) {
            int top = minQue.peek();
            if (nums[j]>top){
                minQue.poll();
                minQue.offer(nums[j]);
            }
        }
        return minQue.peek();
    }
}
