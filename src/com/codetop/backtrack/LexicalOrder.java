package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LexicalOrder {
    /**
     * 递归
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n, i, result);
        }
        return result;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(n, i * 10 + j, list);
        }
    }
}
