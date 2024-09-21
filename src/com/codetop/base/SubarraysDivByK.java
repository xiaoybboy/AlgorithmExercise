package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。
 * 子数组 是数组中 连续 的部分。
 */
public class SubarraysDivByK {

    public static void main(String[] args) {
        int[] A = {2, -2, 2, -4};
        subarraysDivByK(A, 6);
    }

    public static int subarraysDivByK(int[] A, int K) {
        int N = A.length, sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= N; i++) {
            sum = sum + A[i - 1];
            int key = (sum % K + K) % K;

            int count = map.getOrDefault(key, 0);
            ans += count;
            map.put(key, count + 1);
        }
        return ans;
    }
}
