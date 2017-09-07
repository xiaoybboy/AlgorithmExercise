package com.company.qunar;

import java.util.ArrayList;
import java.util.List;

/**
 * 现在有一个字符串列表，和一个关键词列表，请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 * <p>
 * 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，请返回一个排好序的含关键词的字符串序号的列表。保证所有字符串长度
 * 小于等于100，关键词个数小于等于100，字符串个数小于等于200
 * 。保证所有字符串全部由小写英文字符组成。若不存在含关键字的字符串，请返回一个只含-1的数组。
 * <p>
 * 测试样例：
 * ["nowcoder","hello","now"],3,["coder",now],2
 * 返回：[0,2]
 *
 * @author XIAO
 * @create 2017-09-07 15:04
 **/
public class KeyWord {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].contains(keys[j])) {
                    list.add(i);
                    break;
                }
            }
        }
        if (list.isEmpty())
            return new int[]{-1};
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            r[i] = list.get(i);
        return r;
    }
}
