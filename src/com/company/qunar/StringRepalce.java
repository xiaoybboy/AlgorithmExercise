package com.company.qunar;

/**
 * 请你实现一个简单的字符串替换函数。原串中需要替换的占位符为"%s",请按照参数列表的顺序一一替换占位符。若参数列表的字符数大于
 * 占位符个数。则将剩下的参数字符添加到字符串的结尾。
 * <p>
 * 给定一个字符串A，同时给定参数字符数组的长度m及参数字符数组arg，请返回替换后的字符串。保证参数个数大于等于占位符个数。保证原串由大小
 * 写英文字母组成，同时长度小于等于500。
 * 测试样例：
 * "A%sC%sE",7,['B','D','F']
 * 返回："ABCDEF"
 *
 * @author XIAO
 * @create 2017-09-07 14:54
 **/
public class StringRepalce {
    public String formatString(String A, int n, char[] arg, int m) {
        String[] AArr = A.split("%s");
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        for (String str : AArr) {
            if (str.length() == 0) {
                buffer.append(arg[i]);
            } else {
                buffer.append(str + arg[i]);
            }
            i++;
        }
        while (i < m) {
            buffer.append(arg[i]);
            i++;
        }
        return buffer.toString();
    }
}
