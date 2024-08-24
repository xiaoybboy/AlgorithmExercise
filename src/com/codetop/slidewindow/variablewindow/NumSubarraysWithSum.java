package com.codetop.slidewindow.variablewindow;

import java.util.HashMap;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 */
public class NumSubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        numSubarraysWithSum(nums, 2);
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            //当前前缀和已知，判断是否含有 presum - k的前缀和，那么我们就知道某一区间的和为 k 了。
            if (map.containsKey(presum - goal)) {
                count += map.get(presum - goal);//获取次数
            }
            //更新
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
