package com.baseAlgorithm;

import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-13 19:50
 **/
public class HuaWei3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        int k = sc.nextInt();

        String[] array = strs.split(" ");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String temp = array[i];
            if (temp.length() < 3) {
                nums[i] = Integer.parseInt(temp);
            } else {
                nums[i] = Integer.parseInt(temp.substring(temp.length() - 3, temp.length()));
            }
        }
        BubbleSort(nums, array);
        System.out.println(array[k - 1]);

    }

    //冒泡排序，稳定排序
    public static void BubbleSort(int[] nums, String[] strs) {
        int length = nums.length;
        //每次排序都把最大值放到最后一位
        for (int i = 0; i < length - 1; i++) {
            // 如果data[j]和data[j+1]反向
            for (int j = 0; j < length - 1 - i; j++)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    //同时交换字符串数组的位置
                    String strtemp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = strtemp;
                }
        }
    }
}
