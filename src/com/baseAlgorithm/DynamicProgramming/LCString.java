package com.baseAlgorithm.DynamicProgramming;

/**
 * 最大公共子串
 * <p>
 * 求字串的方法和求子序列方法类似：
 * 当str1[i] == str2[j]时，子序列长度veca[i][j] = veca[i - 1][j - 1] + 1；只是当str1[i] ！= str2[j]时，
 * veca[i][j]长度要为0，而不是max{veca[i- 1][j], veca[i][j - 1]}。
 *
 * @author XIAO
 */
public class LCString {

    public static StringBuilder maxLCString(String str1, String str2) {
        // 把字符串转成字符数组
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // 把两个字符串分别以行和列组成一个二维矩阵
        int[][] temp = new int[arr1.length][arr2.length];
        // 存储最长公共子串长度
        int maxLenght = 0;
        // start表明最长公共子串的起始点，end在第二个串arr2表明最长公共子串的终止点
        int end = 0;
        int start = 0;
        // 初始化二维矩阵中的第一行
        for (int i = 0; i < arr2.length; i++) {
            temp[0][i] = (arr1[0] == arr2[i]) ? 1 : 0;
        }
        // 初始化二维矩阵中的第一列
        for (int j = 0; j < arr1.length; j++) {
            temp[j][0] = (arr2[0] == arr1[j]) ? 1 : 0;
        }
        // 嵌套for循环：比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;

                    if (temp[i][j] > maxLenght) {
                        maxLenght = temp[i][j];
                        end = j;
                    }
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        // 求出最长公共子串的起始点
        start = end - maxLenght + 1;
        StringBuilder sb = new StringBuilder();
        // 通过查找出值为1的最长对角线就能找到最长公共子串
        for (int j = start; j < end + 1; j++) {
            sb.append(arr2[j]);
        }

        return sb;
    }

    public static void main(String[] args) {
        String aa = "abc123edf";
        String bb = "bc123jg";
        maxLCString(aa, bb);
        System.out.println(maxLCString(aa, bb));
    }

}
