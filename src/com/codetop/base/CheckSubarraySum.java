package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，如果 nums 有一个 好的子数组 返回 true ，否则返回 false：
 * 一个 好的子数组 是：
 * 长度 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 注意：
 * 子数组 是数组中 连续 的部分。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终 视为 k 的一个倍数。
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int j = 0; j < n; j++) {
            int kMod = sum[j] % k;
            if (map.containsKey(kMod)) {
                int first = map.get(kMod);//第一次这个余数出现的位置
                //如果长度>=2,则找到了一个子数组
                if (j - first >= 2) {
                    return true;
                }
            } else {
                map.put(kMod, j);
            }
        }
        return false;
    }
}
