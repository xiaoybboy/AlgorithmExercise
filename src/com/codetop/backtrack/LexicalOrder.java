package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 */
public class LexicalOrder {

    List<Integer> result = new ArrayList<>();

    //回溯，想象树结构，第一层1-9，下面每层都是0-9
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(n, i);
        }
        return result;
    }

    private void dfs(int n, int cur) {
        if (cur > n) {
            return;
        }
        result.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(n, cur * 10 + i);
        }
    }
}
