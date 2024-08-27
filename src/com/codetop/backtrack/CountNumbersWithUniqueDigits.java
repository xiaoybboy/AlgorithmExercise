package com.codetop.backtrack;

import java.util.LinkedList;

/**
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 */
public class CountNumbersWithUniqueDigits {

    int ans = 0;
    LinkedList<Integer> tempList = new LinkedList<>();

    public int countNumbersWithUniqueDigits(int n) {
        backTrack(n);
        return ans;
    }

    private void backTrack(int n) {
        if (tempList.size() == n) {
            ans++;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            backTrack(n);
            tempList.removeLast();
        }
    }

}
