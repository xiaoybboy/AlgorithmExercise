package com.codetop.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 利用前缀和 sum ，遇到 0 时减一，遇到 1 时加一，把前缀和 sum 和下标 i 存入哈希表中。
 * 如果当前 sum 在哈希表中存在，则说明 当前下标 i 到 sum 第一次出现的下标（在哈希表中对应的value），
 * 这个范围内，0 和 1 出现次数相同，因为这个范围内的前缀和为 0 ，迭代最大长度 len 。
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                preSum--;
            } else {
                preSum++;
            }
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
