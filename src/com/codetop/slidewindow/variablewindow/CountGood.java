package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * <p>
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * <p>
 * 子数组 是原数组中一段连续 非空 的元素序列。
 */
public class CountGood {

    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, pairs = 0;
        long result = 0;
        for (int end = 0; end < nums.length; end++) {
            int curNum = nums[end];
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);
            //加上添加end处元素后，新增的对数
            if (map.get(curNum) >= 2) { //1.2
                pairs += map.get(curNum) - 1;
            }

            while (pairs >= k) {
                //右侧的所有一定满足
                result += nums.length - end;
                int startNum = nums[start];
                //窗口左移时，减去左边元素匹配的对数
                if (map.get(startNum) >= 2) { // 3.2
                    pairs -= map.get(startNum) - 1;
                }
                map.put(startNum, map.get(startNum) - 1);
                start++;
            }
        }
        return result;
    }
}
