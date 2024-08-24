package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrack("", 0, 0, n);
        return result;
    }

    public void backTrack(String buffer, int left, int right, int n) {
        if (buffer.length() == 2 * n) {
            result.add(buffer);
            return;
        }
        //剪枝
        if (left < right) {
            return;
        }
        if (left < n) {
            backTrack(buffer + "(", left + 1, right, n);
        }
        if (right < n) {
            backTrack(buffer + ")", left, right + 1, n);
        }
    }
}
