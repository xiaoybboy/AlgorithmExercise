package com.codetop.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，
 * <p>
 * 其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class MergeArray {

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (result.size() == 0) {
                result.add(intervals[i]);
                continue;
            }

            int[] preArray = result.get(result.size() - 1);

            if (left > preArray[1]) {
                result.add(intervals[i]);
            } else {
                preArray[1] = Math.max(preArray[1], right);
            }
        }
        return result.toArray((new int[result.size()][2]));
    }
}
