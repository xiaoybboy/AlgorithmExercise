package com.codetop;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 */
public class IsAdditiveNumber {
    //对于长度为 n 的字符串，第一位的最大长度为(n - 1) / 2，比如 1123581321，第一位的最大长度为 (10-1)/2=4。我们可以这样证明：
    // 如果第一个数字取(n - 1) / 2 + 1位，第二个数字我们最少要取一位，前两个数字的长度就要大于等于 (n + 1) / 2 + 1，
    // 也就是超过了整个字符串长度的一半，那剩下的数字组成的第三个数肯定比前两个数字的和小，不满足条件
    public boolean isAdditiveNumber(String num) {
        int maxLen = num.length();
        for (int i = 0; i <= (maxLen - 1) / 2; i++) {
            long first = Long.parseLong(num.substring(0, i + 1));
            for (int j = i + 1; j < maxLen - i; j++) {
                long second = Long.parseLong(num.substring(i + 1, j + 1));
                if (checkAdditive(first, second, num, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkAdditive(long first, long second, String num, int start) {
        if (start >= num.length()) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(first).append(second);
        while (builder.length() < num.length()) {
            long sum = first + second;
            builder.append(sum);
            first = second;
            second = sum;
        }

        return builder.length() == num.length() && num.equals(builder.toString());
    }
}
