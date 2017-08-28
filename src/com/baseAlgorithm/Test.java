package com.baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        while (sc.hasNextInt()) {
            nums.add(sc.nextInt());
        }
        sc.close();

        if (nums == null || nums.size() == 0) {
            System.out.println(0);
        } else {
            int maxValue = Integer.MIN_VALUE;
            int cur = 0;// 局部子连续数组的和
            for (int i = 0; i < nums.size(); i++) {
                cur += nums.get(i);
                maxValue = Math.max(maxValue, cur);
                if (cur < 0) {
                    cur = 0;// 保证局部子数组的和是正数
                }
            }
            System.out.println(maxValue);
        }
    }
}