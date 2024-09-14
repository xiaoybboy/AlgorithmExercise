package com.codetop.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 1.首先，对于数组中的每一个元素，都有可能成为二叉树最顶部的root节点
     * 2.假设能延伸出 n 种二叉搜索树子树，对于右边的两个节点，假设能延伸出m种二叉搜索树子树。则以5为root节点时的二叉搜索树总数为 m*n
     * 3.这样我们遍历刚刚的nums数组，以值i（注意不是下标）当做根节点，其左边有i-1个节点，右边有n-i个节点，计算出可能的二叉搜索树数量，添加到总结果里即可，
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int right = numTrees(n - i);
            count += (leftNum * right);
        }
        map.put(n, count);
        return count;
    }
}
