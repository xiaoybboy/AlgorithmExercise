package com.codetop.monotonicstack;

import java.util.Stack;

public class SumSubarrayMins {

    /**
     * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
     * <p>
     * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
     * 示例 1：
     * 输入：arr = [3,1,2,4]
     * 输出：17
     * 解释：
     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
     * 示例 2：
     * 输入：arr = [11,81,94,43,3]
     * 输出：444
     */
    int MOD = 1000000007;

    public int sumSubarrayMins(int[] A) {
        Stack<Pair> stack = new Stack<>();
        int res = 0, tmp = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.empty() && stack.peek().val >= A[i]) {
                Pair pop = stack.pop();
                count += pop.count;
                tmp -= pop.val * pop.count;
            }
            stack.push(new Pair(A[i], count));
            tmp += A[i] * count;
            res += tmp;
            res %= MOD;
        }
        return res;
    }
}

class Pair {
    public int val;
    public int count;

    public Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
