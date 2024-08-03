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

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        int m = potions.length;
        for (int i = 0; i < spells.length; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            pairs[i] = m - binary(potions, t, 0, m - 1);
        }
        return pairs;
    }

    private int binary(int[] potions, long target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (potions[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
