package com.company.baidu;

import java.util.Scanner;

/**
 * 度度熊有一个N个数的数组，他想将数组从小到大排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 * <p>
 * 输入描述:
 * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 * <p>
 * 输出描述:
 * 输出一个整数表示最少的操作次数。
 * <p>
 * 输入例子1:
 * 4
 * 19 7 8 25
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 思路是这样的，这串数字可以分为两类：一类是不动数另一类是动数。动数的个数就是算法要移动的次数。
 * <p>
 * 不动数满足两个条件：1.后面的数都大于该数。并且,2.前面最小动数大于该数。
 * <p>
 * 动数和不动数刚好相反：1.后面的数至少有一个数大于该数。或者2.前面最小动数小于该数。
 * <p>
 * //  不是不动数的数就是动数。只需要找到所有动数个数，就能得到算法移动次数。
 *
 * @author XIAO
 * @since 2017/8
 */
public class InterestingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        int move_count = 0;  // 记录动数的个数。
        int min_move_value = 1001;  // 初始化最小动数的值。
        for (int i = 0; i < nums.length; i++) {
            if (min_move_value < nums[i]) {
                move_count++;  // 满足动数条件2
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    move_count++;  // 满足动数条件1
                    min_move_value = nums[i];  // 该动数与最小动数值比较
                    break;
                }
            }
        }

        System.out.println(move_count);
    }
}
