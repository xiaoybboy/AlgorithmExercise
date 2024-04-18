package com.codetop.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> result = new ArrayList<>();

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        backTrack(0, digits, new StringBuffer());
        return result;
    }

    private void backTrack(int index, String digits, StringBuffer combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backTrack(index + 1, digits, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
