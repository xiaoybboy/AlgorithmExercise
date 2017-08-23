package com.baseAlgorithm;

/**
 * <p>数组中包含重复元素，给定两个数n1和n2，求n1和n2在数组中的最小距离</p>
 *
 * @author XIAO
 * @create 2017-08-23 15:36
 **/
public class GetMinArrayDistance {
    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 3, 6, 8, 4, 5, 6, 8, 3, 4, 4, 5, 6, 8, 6, 7};
        int minDistance = getMinDistance(nums, 3, 5);
        System.out.println(minDistance);
    }

    private static int getMinDistance(int[] nums, int n1, int n2) {
        int min_diatance = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == n1) {
                index1 = k;
                if (index2 > 0) {
                    min_diatance = Math.min(Math.abs(min_diatance), Math.abs(index1 - index2));
                }
            }

            if (nums[k] == n2) {
                index2 = k;
                if (index1 > 0) {
                    min_diatance = Math.min(Math.abs(min_diatance), Math.abs(index1 - index2));
                }
            }
        }
        return min_diatance;
    }
}