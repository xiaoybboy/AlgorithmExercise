package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。返回数组中 完全子数组 的数目。
 * 子数组 是数组中的一个连续非空序列。
 */
public class CountCompleteSubarrays {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int totalUnique = set.size();
        Map<Integer, Integer> map = new HashMap<>(); // 窗口内元素的出现次数
        int result = 0, n = nums.length;
        int start = 0;
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            // 2、缩小窗口
            // 当窗口内不同元素的数量等于数组中不同元素的总数时，开始缩小窗口
            while (map.size() == totalUnique) {
                // [l,r]唯一元素数目已满足。
                // [r+1,n-1]共n-r-1个元素，加上窗口本身一个，共n-r种可能。
                // 即：[l..r]; [l..r,r+1]; [l..r,r+1,r+2]; ... ; [l..r,r+1..n-1]
                result += n - j; // ***难点
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
        }
        return result;
    }
}
