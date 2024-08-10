package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        shipWithinDays(weights, 4);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int maxValue = Arrays.stream(weights).sum();
        //右边界为所有和，因为当shipWeight>=sum(),都只需要一天
        int start = 0, end = maxValue + 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (check(weights, days, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static boolean check(int[] weights, int days, int weight) {
        int total = 1;
        int tempWeight = weight;
        for (int x : weights) {
            if (x > weight) {
                return true;
            }
            if (tempWeight < x) {
                tempWeight = weight;
                total++;
                if (total > days) {
                    return true;
                }
            }
            tempWeight -= x;
        }
        return false;
    }
}
