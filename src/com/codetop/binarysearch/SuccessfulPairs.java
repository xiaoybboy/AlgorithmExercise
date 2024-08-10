package com.codetop.binarysearch;

import java.util.Arrays;

/**
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * <p>
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * <p>
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 */
public class SuccessfulPairs {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length, m = spells.length;
        int[] pairs = new int[m];
        for (int i = 0; i < m; i++) {
            //乘积>=success,需要的最小值
            long target = success % spells[i] == 0 ? success / spells[i] : success / spells[i] + 1;
            int first = binary(potions, target);
            pairs[i] = (n - first);
        }
        return pairs;
    }

    private static int binary(int[] potions, long target) {
        int start = -1, end = potions.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (potions[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
