package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {

    /**
     * 回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", 0, 0, result, n);
        return result;
    }

    public static void dfs(String buffer, int left, int right, List<String> result, int n) {
        if (buffer.length() == 2 * n) {
            result.add(buffer);
            return;
        }
        if (left < right) {
            // 如果当前已使用左括号的数量小于右括号的数量，则无法形成有效的括号。直接return。
            return;
        }
        if (left < n) {
            dfs(buffer + "(", left + 1, right, result, n);
        }

        if (right < n) {
            dfs(buffer + ")", left, right + 1, result, n);
        }
    }
}
