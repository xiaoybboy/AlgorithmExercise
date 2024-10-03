package com.codetop.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        FindShortestSubArray ar = new FindShortestSubArray();
        ar.findShortestSubArray(nums);
    }

    public class Node {
        int count;
        int first;
        int last;

        public Node(int count, int first, int last) {
            this.count = count;
            this.first = first;
            this.last = last;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        int n = nums.length;
        //1.统计每个数字出现的次数
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                Node node = map.get(nums[i]);
                node.last = i;
                node.count += 1;
            } else {
                Node node = new Node(1, i, i);
                map.put(nums[i], node);
            }
        }
        //2.寻找最短数组
        int maxCount = 0, minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            //大于最大数量，需要更新minLength
            if (node.count > maxCount) {
                minLength = node.last - node.first + 1;
                maxCount = node.count;
            } else if (node.count == maxCount) {
                minLength = Math.min(minLength, node.last - node.first + 1);
            }
        }
        return minLength;
    }
}
