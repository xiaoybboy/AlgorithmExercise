package com.baseAlgorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XIAO
 * @create 2017-09-06 18:45
 **/
public class CombinSum2 {

    private static int num = 0;
    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 4, 6, 7};
        backtracking(candidates, 10, 0);
        System.out.println(num);
    }

    //不允许重复放入
    private static void backtracking(int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        } //凑过头了
        else if (target == 0) {
            num++;//正好凑出答案
            // lists.add(list);
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {//循环试探每个数
                // list.add(candidates[i]);//尝试加入
                //下一次凑target-candidates[i]，不允许重复，从i+1开始
                backtracking(candidates, target - candidates[i], i + 1);
                // list.remove(list.size() - 1);//回退
            }
        }
    }

}
