package com.codetop.base;

/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * 用例可以保证存在这样的划分方法。
 */
public class PartitionDisjoint {

    public static void main(String[] args) {
        int[] nums = {5, 0, 3, 8, 6};
        partitionDisjoint(nums);
    }

    public static int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = Integer.MAX_VALUE;
        int max = nums[0];
        //求不包含自己的左侧元素的最大值
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i - 1]);
            leftMax[i] = max;
        }

        int min = Integer.MAX_VALUE;
        //包含自身的右侧元素的最小值
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            rightMin[i] = min;
        }
        //两个数组比较，左侧元素最大值<右侧元素最小值，则找到分割位置
        for (int j = 0; j < n; j++) {
            if (leftMax[j] <= rightMin[j]) {
                return j;
            }
        }
        return -1;
    }
}
