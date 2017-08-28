package com.company.ctrip;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 输入一个整形数组。 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * <p>
 * 输入 给定一个数组，包含若干个整数。
 * <p>
 * 样例输入
 * <p>
 * 1 -3 5 5 -6 -2 -7
 * <p>
 * 输出
 * <p>
 * 测试数组中子数组所能产生的最大和
 *
 * @author XIAO
 */
public class ArrayMaxSum {

    static int maxSum(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;// 全局子连续数组的最大值
        int cur = 0;// 局部子连续数组的和
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;// 保证局部子数组的和是正数
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<Integer>();
        while (in.hasNext()) {
            int element = in.nextInt();
            ll.add(element);
        }
        Integer[] arr = ll.toArray(new Integer[0]);
        int res;
        res = maxSum(arr);
        System.out.println(res);

    }

}
