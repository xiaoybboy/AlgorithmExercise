package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 */
public class FindLHS {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        findLHS(nums);
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        for (int x : map.keySet()) {
            //要求最大最小差正好是1，必须包含比当前值大1的数
            if (map.containsKey(x + 1)) {
                ans = Math.max(ans, map.get(x) + map.get(x + 1));
            }
        }
        return ans;
    }
}
