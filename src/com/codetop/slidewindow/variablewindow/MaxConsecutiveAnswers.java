package com.codetop.slidewindow.variablewindow;

/**
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
 * 老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * <p>
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * <p>
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 */
public class MaxConsecutiveAnswers {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'F'), maxConsecutiveAnswers(answerKey, k, 'T'));
    }

    public int maxConsecutiveAnswers(String answerKey, int k, char ch) {
        int maxLength = 0;
        int chCount = 0, start = 0;
        for (int end = 0; end < answerKey.length(); end++) {
            //记录字符不等于ch的数量
            if (answerKey.charAt(end) != ch) {
                chCount++;
            }
            //左边界收缩，找到最近的不等于ch的字符位置
            while (chCount > k) {
                if (answerKey.charAt(start) != ch) {
                    chCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     */
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int zeroCount = 0, start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
