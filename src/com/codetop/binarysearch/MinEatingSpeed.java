package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
public class MinEatingSpeed {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        minEatingSpeed(piles, 8);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        //1.蓝色，最终耗时<=h,h红色最终耗时>h
        int maxValue = Arrays.stream(piles).max().getAsInt();
        int n = piles.length;
        if (h == n) {
            return maxValue;
        }
        int lowSpeed = 0, highSpeed = maxValue + 1;
        while (lowSpeed + 1 < highSpeed) {
            int mid = lowSpeed + (highSpeed - lowSpeed) / 2;
            if (checkBlue(piles, mid, h)) {
                //注意这里是highSpeed
                highSpeed = mid;
            } else {
                lowSpeed = mid;
            }
        }
        //蓝色速度为highSpeed
        return highSpeed;
    }

    private static boolean checkBlue(int[] piles, int speed, int h) {
        int totalTime = 0;
        for (int pile : piles) {
            totalTime += pile % speed == 0 ? pile / speed : pile / speed + 1;
            //防止越界
            if (totalTime > h) {
                return false;
            }
        }
        return true;
    }
}
