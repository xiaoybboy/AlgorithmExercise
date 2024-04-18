package com.codetop.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而
 * secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 */
public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);
            if (low <= high) {
                result.add(new int[]{low, high});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray((new int[result.size()][]));
    }
}
