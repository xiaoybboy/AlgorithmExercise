package com.top200;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * <p>
 * 思路：
 * （1）首先对数组进行排序（从小到大）
 * （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
 * （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）
 * ==》数求和问题
 * （4）定义两个指针：左指针（left） 和 右指针（right）
 * （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
 * （6）调整 left 的位置（后移），求解和是否为 target O(n)
 * ==》时间复杂度：O(nlogn) + O(n)
 */
public class ThreeSumEqual0 {

    /**
     * 查找数组中和为0的三元组
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 3) {
            return result;
        }

        Arrays.sort(num);
        //取出第i个数
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                //非正数选完代表选完
                break;
            }
            if (i != 0 && num[i] == num[i - 1]) {
                //去重
                continue;
            }

            //两数求和
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                //先左移 因为排序原因 start 为 相对于 i 第二小值
                while (start < end && num[i] + num[start] + num[end] > 0) {
                    end--;
                }
                if (start < end && num[i] + num[start] + num[end] == 0) {
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);
                    item.add(num[start]);
                    item.add(num[end]);
                    result.add(item);
                    //右移去重，item.get(1) 为上次左边的值，不能重复
                    while (start < end && item.get(1) == num[start]) {
                        start++;
                    }
                } else {
                    //右移增大整体数
                    start++;
                }
            }
        }
        return result;
    }
}
