package com.codetop.base;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
public class ZConvert {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = "";

        boolean down = false;//循环中反向
        int rowIndex = 0;//字符串数组rows中的位置
        for (int i = 0; i < s.length(); i++) {
            rows[rowIndex] += s.charAt(i);//每行新增字符
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                down = !down;//反向
            }
            //向下的时候+1,向上的时候-1
            rowIndex = down ? (rowIndex + 1) : (rowIndex - 1);
        }
        String ans = "";
        for (String x : rows) {
            ans += x;
        }
        return ans;
    }
}
