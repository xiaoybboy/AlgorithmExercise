package com.codetop.base;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int start = 0, end = charArray.length - 1;
        while (start < end) {
            while (start < n && !isVowel(charArray[start])) {
                start++;
            }
            while (end > 0 && !isVowel(charArray[end])) {
                end--;
            }
            if (start < end) {
                swap(charArray, start, end);
                start++;
                end--;
            }
        }
        return new String(charArray);
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
