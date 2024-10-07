package com.codetop.slidewindow.fixwindow;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * s1.s2只包含小写字母
 */
public class CheckInclusion {

    /**
     * 滑动窗口-在上s2上一个长度为s1.length的滑动窗口，
     * 观察滑动窗口中的每个字符的数量，是否与s1 中每个字符数量一致。
     */
    public static boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }
        int[] s1Count = new int[26];
        for (char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }
        int start = 0;
        int[] windowCount = new int[26];
        for (int end = 0; end < s2.length(); end++) {
            windowCount[s2.charAt(end) - 'a']++;
            if (end < s1.length() - 1) {
                continue;
            }
            if (isSame(s1Count, windowCount)) {
                return true;
            }
            windowCount[s2.charAt(start) - 'a']--;
            start++;
        }
        return false;
    }

    private static boolean isSame(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
