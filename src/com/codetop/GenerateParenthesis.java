package com.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", 0, 0, result, n);
        return result;
    }

    /**
     * @param buffer 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param result 结果集
     */
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
