package com.codetop.base;

import java.util.Random;

/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 */
public class RandomPick {

    //注意，Random是一个比较重的类，全局保留一个实例即可
    // 或者使用 Math.random() 或 ThreadLocalRandom.nextInt() 方法
    private Random random;
    private int[] preSum;

    public RandomPick(int[] w) {
        this.random = new Random();
        this.preSum = new int[w.length];
        // 计算前缀和
        this.preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            this.preSum[i] = this.preSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int max = this.preSum[this.preSum.length - 1];
        // 注意，生成的随机数不能包含0，否则部分用例过不了
        int rand = random.nextInt(max) + 1;

        //可以用二分查找优化
        for (int i = 0; i < preSum.length; i++) {
            // 判断rand的范围落在哪个区间
            if (rand <= preSum[i]) {
                return i;
            }
        }
        return 0;
    }
}
