package com.codetop.slidewindow.fixwindow;

/**
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 */
public class MinimumRecolors {

    public int minimumRecolors(String blocks, int k) {
        int start = 0;
        int whiteCount = 0;
        for (int i = 0; i < k; i++) {
            whiteCount += isWhite(blocks.charAt(i));
        }
        int ans = whiteCount;
        for (int j = k; j < blocks.length(); j++) {
            whiteCount = whiteCount + isWhite(blocks.charAt(j)) - isWhite(blocks.charAt(j - k));
            ans = Math.min(whiteCount, ans);
        }
        return ans;
    }

    private int isWhite(char c) {
        return c == 'W' ? 1 : 0;
    }
}
