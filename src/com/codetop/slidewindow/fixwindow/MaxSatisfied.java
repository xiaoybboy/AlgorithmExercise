package com.codetop.slidewindow.fixwindow;

/**
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，
 * 其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 */
public class MaxSatisfied {

    /**
     * 本题可以拆分成两个问题：
     * 1.老板不生气时的顾客数量之和 s0这些顾客可以感到满意。
     * 2.长度为 minutes 的连续子数组中，老板生气时的顾客数量之和 s1的最大值 maxS,这些顾客可以感到满意。
     * 最终答案为 s0+maxS
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //1.获取当前不生气最大满意客户数
        int total = 0;//原本不生气的最大客户数
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        //2.控制minutes不生气窗口获得的增量
        int increase = 0;
        int start = 0, end = 0;
        int maxIncrease = 0;
        while (end < customers.length) {
            //2.1还未到达窗口右边界
            if (end < minutes) {
                increase += getIncrease(end, customers, grumpy);
            } else {
                increase = increase + getIncrease(end, customers, grumpy) - getIncrease(start, customers, grumpy);
                start++;
            }
            maxIncrease = Math.max(increase, maxIncrease);
            end++;
        }
        return total + maxIncrease;
    }

    private int getIncrease(int i, int[] customers, int[] grumpy) {
        if (grumpy[i] == 1) {
            return customers[i];
        }
        return 0;
    }
}
