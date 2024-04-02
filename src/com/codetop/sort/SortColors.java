package com.codetop.sort;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class SortColors {

    /**
     * 设置两个滑动指针，分别为left和right，在初始状态，left指向nums[0]，right指向nums[nums.length - 1]；
     * 设置变量i，对整个nums进行遍历：
     * 当nums[i] == 0时，交换nums[i]和nums[left]，且left ++，i ++；
     * 当nums[i] == 1时，不用做任何交换，i ++；
     * 当nums[i] == 2时，交换nums[i]和nums[right]，且right --。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        //整体把数组分为3部分
        int left = 0;//left表示0的右边界
        int right = nums.length - 1;//right表示2的左边界
        //left和right之间为1的范围
        int i = 0;
        while (left < right && i <= right) {
            if (nums[i] == 0) {
                //如果找到0，就将0和left(0的右边界)互换
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                //如果找到2，就将2和right(0的左边界)互换
                swap(nums, i, right);
                right--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
