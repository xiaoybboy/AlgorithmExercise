package com.codetop.doublePoint;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 修改完输入数组后 ，返回该数组的新长度。
 */
public class Compress {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compress(chars);
    }

    public static int compress(char[] chars) {
        int n = chars.length, write = 0;
        int cur = 0;
        while (cur < n) {
            int count = 1;
            char ch = chars[cur];
            while (cur < n - 1 && chars[cur + 1] == ch) {
                cur++;
                count++;
            }
            String counts = String.valueOf(count);
            chars[write] = ch;
            //如果数量>1
            if (count > 1) {
                for (int j = 0; j < counts.length(); j++) {
                    write++;
                    chars[write] = counts.charAt(j);
                }
            }
            cur++;
            write++;
        }
        return write;
    }
}
