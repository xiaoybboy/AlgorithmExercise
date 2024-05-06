package com.codetop.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
 * <p>
 * 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
 * 找出并返回能够形成的 最长数对链的长度 。
 */
public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }
}
