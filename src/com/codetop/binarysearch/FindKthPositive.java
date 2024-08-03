package com.codetop.binarysearch;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 */
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        //1.划分蓝红区域，蓝色缺失个数<k,红色，缺失>=k
        //2.return left
        int n = arr.length;
        //如果数组第一个数>k
        if (arr[0] > k) {
            return k;
        }
        int left = -1, right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (missingCount(arr, mid) < k) {//isBlue()
                left = mid;
            } else {
                right = mid;
            }
        }
        //K-missingCount(arr, left)表示在arr[left]位置，还缺少几个元素
        //再加上arr[left]就是第k个缺失的元素了
        return arr[left] + (k - missingCount(arr, left));
    }

    //idx位置上，缺失的数量，因为索引从0开始，所以还要-1
    //例如[2,4,6]分别缺失[1,2,3]
    private int missingCount(int[] arr, int idx) {
        return arr[idx] - 1 - idx;
    }
}
