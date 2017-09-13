package com.baseAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author XIAO
 * @create 2017-09-10 15:41
 **/
public class Test5 {

    private static int maxCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        backtracking(nums, 0, 0, 0, new ArrayList<Integer>());
        System.out.println(maxCount);
    }

    //不允许重复放入
    private static void backtracking(int[] candidates, int xorRes, int countTemp, int start, List<Integer>
            tempList) {
        if (start == candidates.length - 1) {
            maxCount = Math.max(maxCount, countTemp);
            return;
        }

        for (int j = start; j < candidates.length; j++) {//循环试探每个数
            tempList.add(candidates[j]);
            xorRes = xorRes ^ candidates[j];
            if (xorRes == 0) {
                backtracking(candidates, xorRes, countTemp + 1, j + 1, tempList);
            }
            tempList.remove(tempList.size() - 1);
        }
    }
}