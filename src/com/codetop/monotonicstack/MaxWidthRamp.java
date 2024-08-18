package com.codetop.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 */
public class MaxWidthRamp {

    public static void main(String[] args) {
        int[] A = {6, 0, 8, 2, 1, 5};
        maxWidthRamp(A);
    }

    public static int maxWidthRamp(int[] A) {
        //栈中保存的是从A[0]开始的递减序列的下标
        Deque<Integer> deque = new ArrayDeque<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            //只保存递减序列的下标，为什么？
            //例如6,4,3,5.为什么不把5算进去，因为栈里面已经有4了，比5小，而且下标更靠前。
            //当从后往前走最大宽度的时候，4一定会比5宽
            if (deque.isEmpty() || A[deque.peek()] > A[i]) {
                deque.push(i);
            }
        }
        int ans = 0;
        //栈内元素，从栈顶到栈底是递增的，从后往前遍历，只需要比较栈顶元素，即可获取最大宽度
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && A[deque.peek()] <= A[i]) {
                ans = Math.max(ans, i - deque.pop());
            }
        }
        return ans;
    }
}
