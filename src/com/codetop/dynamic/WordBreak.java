package com.codetop.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak {
    //dp[i]:s的前i个字符是否可以用字典拼出
    //dp[i] = dp[j] && check(s[j,i])
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        //1.字典
        Set<String> wordDictSet = new HashSet(wordDict);
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //剪枝
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
