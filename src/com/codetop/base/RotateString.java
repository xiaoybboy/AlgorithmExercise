package com.codetop.base;

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 */
public class RotateString {
    //s+s中包含了所有可以旋转获取的字符串
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
