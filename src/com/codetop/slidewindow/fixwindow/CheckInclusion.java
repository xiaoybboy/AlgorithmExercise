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
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        //S1,S2只有小写字母，创建一个包含26个字母的数组，数组的每一位是对应字母的数量
        int[] need = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            need[s1.charAt(i) - 'a']++;
        }
        int[] candidate = new int[26];
        //先找到长度为s1.length的数组
        for (int j = 0; j < s1.length(); j++) {
            candidate[s2.charAt(j) - 'a']++;
        }
        if (check(need, candidate)) {
            return true;
        }
        //开始在s2滑动，不断更新候选数组，并进行比较
        for (int k = s1.length(); k < s2.length(); k++) {
            //去除滑动窗口最左边的字符，并增加当前字符
            candidate[s2.charAt(k - s1.length()) - 'a']--;
            candidate[s2.charAt(k) - 'a']++;
            if (check(need, candidate)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] need, int[] candidate) {
        for (int i = 0; i < need.length; i++) {
            if (need[i] != candidate[i]) {
                return false;
            }
        }
        return true;
    }
}
