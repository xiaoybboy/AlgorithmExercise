package com.codetop.doublePoint;

public class Compress {

    /**
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     * 修改完输入数组后 ，返回该数组的新长度。
     */
    public int compress(char[] chars) {
        int n = chars.length, write = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            //找到下一个不重复的字符
            while (j < n && chars[i] == chars[j])
                j++;
            chars[write++] = chars[i];
            if (j - i > 1) {
                String tmp = Integer.toString(j - i);
                for (int k = 0; k < tmp.length(); k++)
                    chars[write++] = tmp.charAt(k);
            }
            i = j;
        }
        return write;
    }
}
