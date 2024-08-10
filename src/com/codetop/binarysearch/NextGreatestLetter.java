package com.codetop.binarysearch;

/**
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * <p>
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int start = -1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end == n) {
            return letters[0];
        }
        return letters[end];
    }
}
