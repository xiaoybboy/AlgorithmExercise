package com.codetop.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）
 */
public class FurthestBuilding {

    //贪心策略：优先使用梯子，当梯子不够的时候，把高度差最小的替换成砖头
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length, sum = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                queue.offer(diff);
                //如果梯子不够用了
                if (queue.size() > ladders) {
                    //把最低差的替换成砖头
                    bricks -= queue.poll();
                }

                if (bricks < 0) {
                    return i - 1;
                }
            }
        }
        return n - 1;
    }
}
