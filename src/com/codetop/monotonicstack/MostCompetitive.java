package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 */
public class MostCompetitive {

    //贪心+单调栈
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //希望左边的元素尽可能的小。而且需要满足条件：栈的总数量必须等于k
            while (!deque.isEmpty() && deque.peek() > nums[i] && deque.size() + (n - i) > k) {
                deque.pop();
            }
            //栈内元素个数维持在k个
            if (deque.size() < k) {
                deque.push(nums[i]);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = deque.pollLast();
        }
        return ans;
    }
}
