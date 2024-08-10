package com.codetop.binarysearch;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * <p>
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
 */
public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = -1, end = n;
        //蓝色：满足条件至少 有 h 篇论文分别被引用了至少 h 次；红色不满足条件
        //左侧越容易满足条件，右侧不容易满足，找到第一个不满足条件的边界
        //蓝色区域：不满足至少被引用 h 次的论文
        //红色区域：满足至少被引用 h 次的论文
        //返回：所求的 h 位于红色区域内，因此返回 r
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //满足条件：n-mid:论文数量;citations[mid]引用次数
            if (citations[mid] >= n - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return n - end;
    }
}
