package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // 先将结果数组中的值赋值为-1
        Arrays.fill(res, -1);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            // 如果栈不为空，且栈中元素小于当前考察的元素
            // 则当前考察的元素是栈中元素的下一个更大元素
            // i % n 对数组长度取余，模拟循环数组
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i % n]) {
                res[deque.pop()] = nums[i % n];
            }
            // 当前元素的索引取余后入栈，看后面是否有其下一个更大元素
            deque.push(i % n);
        }
        return res;
    }
}
