package com.baseAlgorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XIAO
 * @create 2017-09-06 18:45
 **/
public class CombinSum2 {

    private static int num = 0;

    public static void main(String[] args) {
        int[] candidates = {2, 3, 4, 6, 7};
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            nums.add(candidates[i]);
        }
        backtracking(7, nums);
        System.out.println(num);
    }

    private static void backtracking(int target, List<Integer> nums) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            num++;
        }
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i);
            if (target >= temp) {
                target -= temp;
                nums.remove(i);
                backtracking(target, nums);
                target += temp;
                nums.add(i, temp);
            }
        }
    }
}
