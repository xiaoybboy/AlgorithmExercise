package com.codetop.binarysearch;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须尽可能减少整个过程的操作步骤。
 */
public class FindMin {

    public int findMin(int[] nums) {
        //1.蓝红划分，蓝色区域值大与右边界，红色<=右边界
        //2.return end
        int n = nums.length;
        int start = -1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int target = end == n ? nums[n - 1] : nums[end];
            if (nums[mid] > target) {
                start = mid;
            } else if (nums[mid] < target) {
                end = mid;
            } else {
                //特殊情况处理=右边界的值缩小红色区域
                end--;
            }
        }
        return nums[end];
    }
}
