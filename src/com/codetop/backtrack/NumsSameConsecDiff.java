package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 返回所有长度为 n 且满足其每两个连续位上的数字之间的差的绝对值为 k 的 非负整数 。
 * <p>
 * 请注意，除了 数字 0 本身之外，答案中的每个数字都 不能 有前导零。例如，01 有一个前导零，所以是无效的；但 0 是有效的。
 * 你可以按 任何顺序 返回答案
 */
public class NumsSameConsecDiff {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> tempList = new LinkedList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        backTrack(0, n, k);
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            StringBuilder builder = new StringBuilder();

        }
        return null;
    }

    private void backTrack(int start, int n, int k) {
        if (start == n - 1) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (start == 0 && i == 0) {
                continue;
            }
            if (start != 0) {
                int pre = tempList.getLast();
                int next = (pre + k) % 10;
                if (i != next) {
                    continue;
                }
            }
            tempList.add(i);
            backTrack(start + 1, n, k);
            tempList.removeLast();
        }
    }
}
