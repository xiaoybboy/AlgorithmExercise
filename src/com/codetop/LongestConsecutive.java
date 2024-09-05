package com.codetop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive {

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int maxLen = 0;
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            int len = 1;
            while (set.contains(++x)) {
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    /**
     * 每次遍历到新数字时，去hashMap中寻找比它小1的数字和比它大1的数字对应的长度，记为min和max。
     * 如果min、max均为0，说明此时不存在上下界，直接记为1.
     * 当出现min、max不为0时，说明与当前数字有新的上下界，计算出上下界所对应的数字，并在map中修改对应的上下界大小。
     * <p>
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //如果已经处理过这个数字，则不再处理了
            if (map.containsKey(num)) {
                continue;
            }
            //寻找比当前值小1，和比当前值大1，长度
            int min = map.getOrDefault(num - 1, 0);
            int max = map.getOrDefault(num + 1, 0);

            int now = max + min + 1;
            //更新上下界的值
            map.put(num + max, now);
            map.put(num - min, now);
            map.put(num, now);
            maxLen = Math.max(now, maxLen);
        }
        return maxLen;
    }
}
